package edu.hillel.lesson24;

import org.junit.Before;
import org.junit.Test;
import java.io.File;
import static org.junit.Assert.assertTrue;

public class StorageFactoryTest {
    private StorageFactory inMemoryFactory;
    private StorageFactory fileSystemFactory;
    private StorageFactory databaseFactory;

    @Before
    public void setUp() {
        fileSystemFactory = new FileSystemStorageFactory(new File("test-directory"));
        inMemoryFactory = new InMemoryStorageFactory();
        databaseFactory = new DatabaseStorageFactory("jdbc:mysql://localhost:3306/testing","root","root");
    }

    @Test
    public void testInMemoryStorageCreation() {
        Storage inMemoryStorage = inMemoryFactory.createStorage();
        assertTrue(inMemoryStorage instanceof InMemoryStorage);
    }

    @Test
    public void testFileSystemStorageCreation() {
        Storage fileSystemStorage = fileSystemFactory.createStorage();
        assertTrue(fileSystemStorage instanceof FileSystemStorage);
    }

    @Test
    public void testDatabaseStorageCreation() {
        Storage databaseStorage = databaseFactory.createStorage();
        assertTrue(databaseStorage instanceof DatabaseStorage);
    }
}