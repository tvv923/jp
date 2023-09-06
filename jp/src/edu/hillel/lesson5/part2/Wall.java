package edu.hillel.lesson5.part2;

public class Wall implements Obstacle {
    private final int height;

    private final String name;

    public Wall(int height, String name) {
        this.height = height;
        this.name = name;
    }

    public boolean overcome(Participant participant) {
        if (participant.isDisqualified()) {
            return false;
        }
        participant.jump(height);
        if (!participant.isDisqualified()) {
            System.out.println("Учасник " + participant.getName() + " подолав перешкоду '" + name + "' висотою " + height + " метрів.");
            return true;
        } else {
            System.out.println("Учасник " + participant.getName() + " не пройшов перешкоду '" + name + "' висотою " + height + " метрів. Пройдено " + participant.getMaxHeight() + " метрів.");
            return false;
        }
    }
}