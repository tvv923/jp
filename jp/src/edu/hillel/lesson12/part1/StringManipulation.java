package edu.hillel.lesson12.part1;

import java.util.List;

public class StringManipulation {
    public static int countOccurance(List<String> stringList, String target) {
        int count = 0;
        for (String str : stringList) {
            if (str.equals(target)) {
                count++;
            }
        }
        return count;
    }
}