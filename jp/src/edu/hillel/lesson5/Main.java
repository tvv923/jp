package edu.hillel.lesson5;
import edu.hillel.lesson5.part1.*;
import edu.hillel.lesson5.part2.*;

public class Main {
    public static void main(String[] args) {
        GeometricShape[] shapes = new GeometricShape[3];
        shapes[0] = new Circle(5.0);
        shapes[1] = new Triangle(4.0, 6.0);
        shapes[2] = new Square(7.0);
        TotalCalculator calc = new TotalCalculator();
        System.out.println("Загальна площа всіх фігур: " + calc.calculateTotalArea(shapes) + "\n");


        Participant[] participants = {
                new Human("Василь", 1000, 2),
                new Cat("Мурзік", 300, 3),
                new Robot("Робокоп", 5000, 1)
        };

        Obstacle[] obstacles = {
                new Track(800, "Довга бігова доріжка"),
                new Wall(1, "Низька стіна"),
                new Track(400, "Коротка бігова доріжка"),
                new Wall(2, "Висока стіна")
        };

        for (Participant participant : participants) {
            boolean passedAllObstacles = true;
            for (Obstacle obstacle : obstacles) {
                if (!obstacle.overcome(participant)) {
                    passedAllObstacles = false;
                    break;
                }
            }
            if (passedAllObstacles) {
                System.out.println("Учасник " + participant.getName() + " успішно пройшов перешкоди.");
            } else {
                System.out.println("Учасник " + participant.getName() + " не зміг пройти всі перешкоди.");
            }
        }
    }
}


