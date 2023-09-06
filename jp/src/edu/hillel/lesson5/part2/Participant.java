package edu.hillel.lesson5.part2;

public interface Participant {
    void run(int distance);

    void jump(int height);

    boolean isDisqualified();

    String getName();

    int getMaxDistance();

    int getMaxHeight();
}
