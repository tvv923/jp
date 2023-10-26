package edu.hillel.lesson21;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LessonDao {
    private Connection connection;

    public LessonDao(Connection connection) {
        this.connection = connection;
    }

    public int addHomework(Homework homework) throws SQLException {
        String query = "INSERT INTO Homework (name, description) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, homework.getName());
            statement.setString(2, homework.getDescription());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            generatedKeys.next();
            return generatedKeys.getInt(1);
        }
    }

    public void deleteHomework(int homeworkId) throws SQLException {
        String deleteHomeworkQuery = "DELETE FROM Homework WHERE id = ?";
        try (PreparedStatement deleteHomeworkStatement = connection.prepareStatement(deleteHomeworkQuery)) {
            deleteHomeworkStatement.setInt(1, homeworkId);
            deleteHomeworkStatement.executeUpdate();
        }
    }

    public void addLesson(Lesson lesson) throws SQLException {
        String query = "INSERT INTO Lesson (name, updatedAt, homework_id) VALUES (?, NOW(), ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, lesson.getName());
            statement.setInt(2, lesson.getHomework().getId());
            statement.executeUpdate();
        }
    }

    public void deleteLesson(int lessonId) throws SQLException {
        String query = "DELETE FROM Lesson WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, lessonId);
            statement.executeUpdate();
        }
    }

    public List<Lesson> getAllLessons() throws SQLException {
        List<Lesson> lessons = new ArrayList<>();
        String query = "SELECT l.id, l.name, h.id AS homework_id, h.name AS homework_name, h.description AS homework_description FROM Lesson l " +
                "JOIN Homework h ON l.homework_id = h.id";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int lessonId = resultSet.getInt("id");
                String lessonName = resultSet.getString("name");
                int homeworkId = resultSet.getInt("homework_id");
                String homeworkName = resultSet.getString("homework_name");
                String homeworkDescription = resultSet.getString("homework_description");

                Homework homework = new Homework(homeworkId, homeworkName, homeworkDescription);

                Lesson lesson = new Lesson(lessonId, lessonName, homework);

                lessons.add(lesson);
            }
        }
        return lessons;
    }

    public Lesson getLessonById(int lessonId) throws SQLException {
        String query = "SELECT l.name, h.id AS homework_id, h.name AS homework_name, h.description AS homework_description " +
                "FROM Lesson l JOIN Homework h ON l.homework_id = h.id WHERE l.id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, lessonId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String lessonName = resultSet.getString("name");
                    int homeworkId = resultSet.getInt("homework_id");
                    String homeworkName = resultSet.getString("homework_name");
                    String homeworkDescription = resultSet.getString("homework_description");

                    Homework homework = new Homework(homeworkId, homeworkName, homeworkDescription);

                    Lesson lesson = new Lesson(lessonName, homework);
                    return lesson;
                }
            }
        }
        return null;
    }
}
