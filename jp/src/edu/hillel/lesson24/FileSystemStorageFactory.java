package edu.hillel.lesson24;

import java.io.File;

public class FileSystemStorageFactory extends StorageFactory {
    private File storageDirectory;

    public FileSystemStorageFactory(File storageDirectory) {
        this.storageDirectory = storageDirectory;
    }

    @Override
    public Storage createStorage() {
        if (!storageDirectory.exists()) {
            if (!storageDirectory.mkdirs()) {
                throw new RuntimeException("Failed to create storage directory");
            }
        }

        if (!storageDirectory.isDirectory()) {
            throw new RuntimeException("Storage directory is not a directory");
        }

        return new FileSystemStorage(storageDirectory);
    }
}