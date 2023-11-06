package edu.hillel.lesson24;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            StorageFactory inMemoryFactory = new InMemoryStorageFactory();
            Storage inMemoryStorage = inMemoryFactory.createStorage();

            StorageFactory fileSystemFactory = new FileSystemStorageFactory(new File("test-directory"));
            Storage fileSystemStorage = fileSystemFactory.createStorage();

            StorageFactory databaseFactory = new DatabaseStorageFactory("jdbc:mysql://localhost:3306/testing","root","root");
            Storage databaseStorage = databaseFactory.createStorage();

            inMemoryStorage.put("key1", "value1");
            String inMemoryValue = inMemoryStorage.get("key1");
            System.out.println("InMemory Storage: " + inMemoryValue);

            fileSystemStorage.put("key2", "value2");
            String fileSystemValue = fileSystemStorage.get("key2");
            System.out.println("FileSystem Storage: " + fileSystemValue);

            databaseStorage.put("key3", "value3");
            String databaseValue = databaseStorage.get("key3");
            System.out.println("Database Storage: " + databaseValue);
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}