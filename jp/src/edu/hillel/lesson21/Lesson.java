package edu.hillel.lesson21;

public class Lesson {
    private int id;
    private String name;
    private Homework homework;

    public Lesson(String name, Homework homework) {
        this.name = name;
        this.homework = homework;
    }

    public Lesson(int id, String name, Homework homework) {
        this.id = id;
        this.name = name;
        this.homework = homework;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Homework getHomework() {
        return homework;
    }

    @Override
    public String toString() {
        return "LessonInfo {lessonId='" + id +
                "', lessonName=" + name +
                ", homeworkId='" + homework.getId() +
                ", homeworkName='" + homework.getName() +
                ", homeworkDescription='" + homework.getDescription() +
                "'}";
    }
}
