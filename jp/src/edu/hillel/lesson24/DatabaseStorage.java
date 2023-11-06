package edu.hillel.lesson24;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseStorage implements Storage {
    private Connection connection;

    public DatabaseStorage(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void put(String key, String value) {
        try (PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO data (mykey, value) VALUES (?, ?)")) {
            insertStatement.setString(1, key);
            insertStatement.setString(2, value);
            insertStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String get(String key) {
        try (PreparedStatement selectStatement = connection.prepareStatement("SELECT value FROM data WHERE mykey = ?")) {
            selectStatement.setString(1, key);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("value");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}