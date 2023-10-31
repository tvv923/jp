package edu.hillel.lesson24;

public class InMemoryStorageFactory extends StorageFactory {
    @Override
    public Storage createStorage() {
        return new InMemoryStorage();
    }
}
