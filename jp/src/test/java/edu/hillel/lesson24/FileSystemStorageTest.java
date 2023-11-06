package edu.hillel.lesson24;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.io.File;
import static org.junit.Assert.assertEquals;

public class FileSystemStorageTest {
    private StorageFactory storageFactory;
    private Storage storage;
    private File testDirectory;

    @Before
    public void setUp() {
        testDirectory = new File("test-directory");
        testDirectory.mkdir();
        storageFactory = new FileSystemStorageFactory(testDirectory);
        storage = storageFactory.createStorage();
    }

    @Test
    public void testFileSystemStoragePutAndGet() {
        storage.put("key1", "value1");
        assertEquals("value1", storage.get("key1"));
    }

    @Test
    public void testFileSystemStoragePutAndGetMultipleKeys() {
        storage.put("key1", "value1");
        storage.put("key2", "value2");
        storage.put("key3", "value3");

        assertEquals("value1", storage.get("key1"));
        assertEquals("value2", storage.get("key2"));
        assertEquals("value3", storage.get("key3"));
    }

    @After
    public void tearDown() {
        if (testDirectory.exists() && testDirectory.isDirectory()) {
            File[] files = testDirectory.listFiles();
            if (files != null) {
                for (File file : files) {
                    file.delete();
                }
            }
            testDirectory.delete();
        }
    }
}