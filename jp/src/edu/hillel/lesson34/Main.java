package edu.hillel.lesson34;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            StudentDAO studentDAO = new StudentDAO();

            int numberOfStudentsToAdd = 4;
            for (int i = 1; i <= numberOfStudentsToAdd; i++) {
                Student newStudent = new Student();
                newStudent.setName("Student " + i);
                newStudent.setEmail("student" + i + "@example.com");
                studentDAO.addStudent(newStudent);
            }
            int numberOfCoursesToAdd = 3;
            for (int i = 1; i <= numberOfCoursesToAdd; i++) {
                Course newCourse = new Course();
                newCourse.setName("Course " + i);
                studentDAO.addCourse(newCourse);
            }
            List<Student> allStudents = studentDAO.getAllStudents();
            for (Student student : allStudents) {
                for (Course course : studentDAO.getAllCourses()) {
                    studentDAO.addCourseToStudent(student.getId(), course.getId());
                }
            }

            Student studentToUpdate = studentDAO.getStudentById(1);
            if (studentToUpdate != null) {
                studentToUpdate.setName("Updated Student");
                studentDAO.updateStudent(studentToUpdate);
            }

            studentDAO.deleteStudent(2);
            allStudents = studentDAO.getAllStudents();
            for (Student student : allStudents) {
                System.out.println(student);
                System.out.println("Courses: " + student.getCourses());
            }

            Student retrievedStudent = studentDAO.getStudentById(3);
            System.out.println("\nRetrieved Student:");
            if (retrievedStudent != null) {
                System.out.println(retrievedStudent);
                System.out.println("Courses: " + retrievedStudent.getCourses());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateSession.getSessionFactory().close();
        }
    }
}