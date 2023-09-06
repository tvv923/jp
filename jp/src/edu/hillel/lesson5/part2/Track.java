package edu.hillel.lesson5.part2;

public class Track implements Obstacle {
    private final int distance;

    private final String name;

    public Track(int distance, String name) {
        this.distance = distance;
        this.name = name;
    }

    public boolean overcome(Participant participant) {
        if (participant.isDisqualified()) {
            return false;
        }
        participant.run(distance);
        if (!participant.isDisqualified()) {
            System.out.println("Учасник " + participant.getName() + " подолав перешкоду '" + name + "' на дистанції " + distance + " метрів.");
            return true;
        } else {
            System.out.println("Учасник " + participant.getName() + " не пройшов перешкоду '" + name + "' на дистанції " + distance + " метрів. Пройдено " + participant.getMaxDistance() + " метрів.");
            return false;
        }
    }
}