package edu.hillel.lesson7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringUtils stringUtils = new StringUtils();
        String source = "Apollo";
        String target = "pollo";
        char charToSearch = 'o';
        String source1 = "ERE";
        String source2 = "Allo";
        System.out.println("Number of occurrences of a character '" + charToSearch + "' in a string '" + source + "': " + stringUtils.findSymbolOccurrence(source, charToSearch));
        System.out.println("Position of word '" + target + "' in string '" + source + "': " + stringUtils.findWordPosition(source, target));
        System.out.println("Reversed string '" + source + "': " + stringUtils.stringReverse(source));
        System.out.println("Is palindrome '" + source1 + "': " + stringUtils.isPalindrome(source1));
        System.out.println("Is palindrome '" + source2 + "': " + stringUtils.isPalindrome(source2));

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        WordGame wordGame = new WordGame(words);
        String secretWord = wordGame.getSecretWord();
        wordGame.showSecretWords();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nTry to guess the secret word.");
        while (true) {
            System.out.print("Enter your guess: ");
            String userGuess = scanner.nextLine().toLowerCase();

            if (userGuess.equals(secretWord)) {
                System.out.println("Congratulations! You guessed the word.");
                break;
            } else {
                String hint = wordGame.generateHint(secretWord, userGuess);
                System.out.println("Incorrect guess. Hint: " + hint);
            }
        }
        scanner.close();
    }
}
