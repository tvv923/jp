package edu.hillel.lesson23.Builder;

public class Car {
    private String body;
    private String engine;
    private String wheels;

    // Конструктор
    public Car(String body, String engine, String wheels) {
        this.body = body;
        this.engine = engine;
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return "New Car {body='" + body +
                "', engine='" + engine +
                "', wheels='" + wheels +
                "'}";
    }
}
