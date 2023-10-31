package edu.hillel.lesson23.Builder;

public class Car {
    private String body;
    private String engine;
    private String wheels;

    public static class CarBuilder {
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
            Car car = new Car();
            car.body = this.body;
            car.engine = this.engine;
            car.wheels = this.wheels;
            return car;
        }
    }

    @Override
    public String toString() {
        return "New Car {body='" + body +
                "', engine='" + engine +
                "', wheels='" + wheels +
                "'}";
    }
}
