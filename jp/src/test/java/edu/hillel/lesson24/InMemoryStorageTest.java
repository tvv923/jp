package edu.hillel.lesson24;

import org.junit.Before;
//import org.junit.After;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class InMemoryStorageTest {
    private StorageFactory storageFactory;
    private Storage storage;

    @Before
    public void setUp() {
        storageFactory = new InMemoryStorageFactory();
        storage = storageFactory.createStorage();
    }

    @Test
    public void testInMemoryStoragePutAndGet() throws FileNotFoundException {
        storage.put("key1", "value1");
        assertEquals("value1", storage.get("key1"));
    }

    @Test
    public void testInMemoryStoragePutAndGetMultipleKeys() throws FileNotFoundException {
        storage.put("key1", "value1");
        storage.put("key2", "value2");
        storage.put("key3", "value3");

        assertEquals("value1", storage.get("key1"));
        assertEquals("value2", storage.get("key2"));
        assertEquals("value3", storage.get("key3"));
    }

    @Test
    public void testInMemoryStorageNonExistentKey() throws FileNotFoundException {
        assertNull(storage.get("nonexistent"));
    }

    /*@After
    public void tearDown() {
        // No cleanup needed for in-memory storage
    }*/
}