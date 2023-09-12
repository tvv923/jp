package edu.hillel.lesson12.part1;

import java.util.ArrayList;
import java.util.List;

public class ArrayToListConversion {
    public static List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num);
        }
        return list;
    }
}