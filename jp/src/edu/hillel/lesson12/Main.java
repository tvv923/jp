package edu.hillel.lesson12;

import edu.hillel.lesson12.part1.*;
import edu.hillel.lesson12.phonebook.TelephoneDirectory;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "date");
        String target = "apple";
        int occurrences = StringManipulation.countOccurance(stringList, target);
        System.out.println("Source list of Strings: " + stringList + ". " +"Occurrences of '" + target + "': " + occurrences);

        int[] intArray = {1, 2, 3, 4, 5};
        List<Integer> intList = ArrayToListConversion.toList(intArray);
        System.out.println("Source array: " + Arrays.toString(intArray) + ". " + "List from array: " + intList);

        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 4, 5, 5, 5);
        List<Integer> uniqueNumbers = UniqueNumbers.findUnique(numbers);
        System.out.println("Source numbers: " + numbers + ". " +"Unique numbers: " + uniqueNumbers);

        List<String> wordList = Arrays.asList("bird", "fox", "bird", "cat", "bird", "fox", "dog", "cat", "fox", "bird");
        System.out.println("Source word list: " + wordList);
        WordOccurrence.calcOccurance(wordList);

        List<String> wordList2 = Arrays.asList("bird", "fox", "bird", "cat", "bird", "fox", "dog", "cat", "fox", "bird");
        List<WordOccurrenceStruct.WordInfo> wordInfoList = WordOccurrenceStruct.findOccurance(wordList2);
        for (WordOccurrenceStruct.WordInfo wordInfo : wordInfoList) {
            System.out.println("Word: " + wordInfo.name() + ", Occurrences: " + wordInfo.occurrence());
        }

        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();
        TelephoneDirectory.Entry entry1 = new TelephoneDirectory.Entry("John", "123-456-7890");
        TelephoneDirectory.Entry entry2 = new TelephoneDirectory.Entry("Alice", "987-654-3210");
        TelephoneDirectory.Entry entry3 = new TelephoneDirectory.Entry("John", "555-555-5555");

        telephoneDirectory.add(entry1);
        telephoneDirectory.add(entry2);
        telephoneDirectory.add(entry3);

        String searchName = "John";
        TelephoneDirectory.Entry foundEntry = telephoneDirectory.find(searchName);
        if (foundEntry != null) {
            System.out.println("Found " + searchName + "'s phone number: " + foundEntry.phoneNumber());
        } else {
            System.out.println(searchName + " not found in the directory.");
        }

        List<TelephoneDirectory.Entry> foundEntries = telephoneDirectory.findAll(searchName);
        if (!foundEntries.isEmpty()) {
            System.out.println("All entries for " + searchName + ":");
            for (TelephoneDirectory.Entry entry : foundEntries) {
                System.out.println(entry.name() + ": " + entry.phoneNumber());
            }
        } else {
            System.out.println(searchName + " not found in the directory.");
        }
    }
}