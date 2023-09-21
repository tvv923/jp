package edu.hillel.lesson13;

public class FileData {
    private final String name;
    private final long size;
    private final String path;

    public FileData(String name, long size, String path) {
        this.name = name;
        this.size = size;
        this.path = path;
    }

    public long getSize() {
        return size;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "FileData {name='" + name + "', size=" + size + ", path='" + path + "'}";
    }
}
