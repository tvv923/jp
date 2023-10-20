package edu.hillel.lesson21;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            DataBaseConnection dbConnection = new DataBaseConnection();
            Connection connection = dbConnection.getConnection();
            LessonDao lessonDao = new LessonDao(connection);

            Homework homework1 = new Homework("Monday homework", "Relax after Sunday");
            Homework homework2 = new Homework("Tuesday homework", "Preparation for work");
            Homework homework3 = new Homework("Wednesday homework", "Beginning of work");

            homework1.setId(lessonDao.addHomework(homework1));
            homework2.setId(lessonDao.addHomework(homework2));
            homework3.setId(lessonDao.addHomework(homework3));

            Lesson lesson1 = new Lesson("Mathematics", homework1);
            Lesson lesson2 = new Lesson("Physics", homework1);
            Lesson lesson3 = new Lesson("Literature", homework2);
            Lesson lesson4 = new Lesson("Chemistry", homework2);
            Lesson lesson5 = new Lesson("History", homework3);
            Lesson lesson6 = new Lesson("Geography", homework3);

            lessonDao.addLesson(lesson1);
            lessonDao.addLesson(lesson2);
            lessonDao.addLesson(lesson3);
            lessonDao.addLesson(lesson4);
            lessonDao.addLesson(lesson5);
            lessonDao.addLesson(lesson6);

            System.out.println("\nAll lessons: ");
            List<Lesson> allLessons = lessonDao.getAllLessons();
            for (Lesson lesson : allLessons) {
                System.out.println(lesson);
            }

            Lesson lessonById = lessonDao.getLessonById(1);
            System.out.println("\nLesson (by ID): " + lessonById);

            lessonDao.deleteLesson(2);
            System.out.println("\nAfter lesson removing: ");
            List<Lesson> afterLessonDel = lessonDao.getAllLessons();
            for (Lesson lesson : afterLessonDel) {
                System.out.println(lesson);
            }

            lessonDao.deleteHomework(3);
            System.out.println("\nAfter homework removing: ");
            List<Lesson> afterHomeworkDel = lessonDao.getAllLessons();
            for (Lesson lesson : afterHomeworkDel) {
                System.out.println(lesson);
            }

            connection.close();
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
