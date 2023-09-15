package edu.hillel.lesson12.part1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordOccurrenceStruct {
    public static List<WordInfo> findOccurance(List<String> stringList) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : stringList) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        List<WordInfo> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            WordInfo wordInfo = new WordInfo(entry.getKey(), entry.getValue());
            result.add(wordInfo);
        }
        return result;
    }

    public record WordInfo(String name, int occurrence) {
    }
}