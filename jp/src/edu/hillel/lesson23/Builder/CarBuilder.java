package edu.hillel.lesson23.Builder;

public class CarBuilder {
    private String body;
    private String engine;
    private String wheels;

    public CarBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    public CarBuilder setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public CarBuilder setWheels(String wheels) {
        this.wheels = wheels;
        return this;
    }

    public Car build() {
        return new Car(body, engine, wheels);
    }
}
