package edu.hillel.lesson12.part1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordOccurrence {
    public static void calcOccurance(List<String> stringList) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : stringList) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}