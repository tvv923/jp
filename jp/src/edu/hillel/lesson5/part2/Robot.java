package edu.hillel.lesson5.part2;

public class Robot implements Participant {
    private final String name;
    private final int maxRunDistance;
    private final int maxJumpHeight;
    private boolean disqualified;

    public Robot(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.disqualified = false;
    }

    public void run(int distance) {
        disqualified = !disqualified && distance > maxRunDistance;
    }

    public void jump(int height) {
        disqualified = !disqualified && height > maxJumpHeight;
    }

    public boolean isDisqualified() {
        return disqualified;
    }

    public String getName() {
        return name;
    }

    public int getMaxDistance() {
        return maxRunDistance;
    }

    public int getMaxHeight() {
        return maxJumpHeight;
    }
}
