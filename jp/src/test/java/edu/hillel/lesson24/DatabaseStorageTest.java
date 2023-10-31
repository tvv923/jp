package edu.hillel.lesson24;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseStorageTest {
    private StorageFactory storageFactory;
    private Connection connection;

    @Before
    public void setUp() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing","root","root");
            Statement createTableStatement = connection.createStatement();
            createTableStatement.execute("CREATE TABLE IF NOT EXISTS data (id INT AUTO_INCREMENT PRIMARY KEY, mykey VARCHAR(10), value VARCHAR(10))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDatabaseStorage() throws FileNotFoundException {
        storageFactory = new DatabaseStorageFactory("jdbc:mysql://localhost:3306/testing","root","root");
        Storage storage = storageFactory.createStorage();

        storage.put("key1", "value1");
        assertEquals("value1", storage.get("key1"));
    }

    @After
    public void tearDown() {
        try {
            if (connection != null) {
                Statement createTableStatement = connection.createStatement();
                createTableStatement.execute("DROP TABLE IF EXISTS data");
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}