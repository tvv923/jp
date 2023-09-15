package edu.hillel.lesson13;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileNavigator {
    private Map<String, List<FileData>> filesMap;

    public FileNavigator() {
        filesMap = new HashMap<>();
    }

    public void addPath(String path) {
        if (!filesMap.containsKey(path)) {
            filesMap.put(path, new ArrayList<>());
        }
    }

    public void add(FileData file) {
        String path = file.getPath();
        if (!filesMap.containsKey(path)) {
            System.out.println("Error: There are no keys matching the folder " + path);
            return;
        }
        filesMap.get(path).add(file);
    }

    public List<FileData> find(String path) {
        return filesMap.getOrDefault(path, new ArrayList<>());
    }

    public List<FileData> filterBySize(long maxSize) {
        List<FileData> result = new ArrayList<>();
        for (List<FileData> files : filesMap.values()) {
            for (FileData file : files) {
                if (file.getSize() <= maxSize) {
                    result.add(file);
                }
            }
        }
        return result;
    }

    public void remove(String path) {
        filesMap.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> result = new ArrayList<>();
        for (List<FileData> files : filesMap.values()) {
            result.addAll(files);
        }
        result.sort((f1, f2) -> Long.compare(f1.getSize(), f2.getSize()));
        return result;
    }
}