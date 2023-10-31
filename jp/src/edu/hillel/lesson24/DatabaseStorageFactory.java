package edu.hillel.lesson24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseStorageFactory extends StorageFactory {
    private String dbUrl;
    private String user;
    private String password;

    public DatabaseStorageFactory(String dbUrl, String user, String password) {
        this.dbUrl = dbUrl;
        this.user = user;
        this.password = password;
    }

    @Override
    public Storage createStorage() {
        try {
            Connection connection = DriverManager.getConnection(dbUrl, user, password);
            Statement createTableStatement = connection.createStatement();
            createTableStatement.execute("CREATE TABLE IF NOT EXISTS data (id INT AUTO_INCREMENT PRIMARY KEY, mykey VARCHAR(10), value VARCHAR(10))");
            return new DatabaseStorage(connection);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating DatabaseStorage", e);
        }
    }
}
