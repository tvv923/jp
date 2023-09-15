package edu.hillel.lesson13;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileNavigator navigator = new FileNavigator();
        navigator.addPath("/path/to/files");
        navigator.addPath("/path/to/files");
        navigator.addPath("/another/path");
        navigator.addPath("/another/path/to");

        navigator.add(new FileData("file1.txt", 1024, "/path/to/files"));
        navigator.add(new FileData("file2.txt", 2048, "/path/to/files"));
        navigator.add(new FileData("file3.txt", 512, "/another/path"));
        navigator.add(new FileData("file4.txt", 256, "/another/path/to"));
        navigator.add(new FileData("file5.txt", 128, "/another/path/files"));

        List<FileData> filesAtPath = navigator.find("/path/to/files");
        System.out.println("Files at /path/to/files:");
        for (FileData file : filesAtPath) {
            System.out.println(file);
        }

        List<FileData> filteredFiles = navigator.filterBySize(1500);
        System.out.println("Files with size <= 1500 bytes:");
        for (FileData file : filteredFiles) {
            System.out.println(file);
        }

        navigator.remove("/another/path/to");

        List<FileData> sortedFiles = navigator.sortBySize();
        System.out.println("Sorted files by size:");
        for (FileData file : sortedFiles) {
            System.out.println(file);
        }
    }
}
