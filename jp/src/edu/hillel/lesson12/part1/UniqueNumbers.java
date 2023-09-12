package edu.hillel.lesson12.part1;

import java.util.ArrayList;
import java.util.List;

public class UniqueNumbers {
    public static List<Integer> findUnique(List<Integer> numbers) {
        List<Integer> uniqueNumbers = new ArrayList<>();
        for (Integer num : numbers) {
            if (!uniqueNumbers.contains(num)) {
                uniqueNumbers.add(num);
            }
        }
        return uniqueNumbers;
    }
}