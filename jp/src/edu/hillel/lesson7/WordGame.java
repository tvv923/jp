package edu.hillel.lesson7;

import java.util.Random;

public class WordGame {
    private String secretWord;
    private String[] sourceWords;

    public WordGame(String[] words) {
        Random random = new Random();
        sourceWords = words;
        secretWord = sourceWords[random.nextInt(sourceWords.length)];
    }

    public void showSecretWords() {
        System.out.print("\nArray of secret words: ");
        for (String word : sourceWords) {
            System.out.print(word + " ");
        }
    }

    public String generateHint(String secretWord, String userGuess) {
        StringBuilder hint = new StringBuilder();
        for (int i = 0; i < secretWord.length(); i++) {
            if (i < userGuess.length() && secretWord.charAt(i) == userGuess.charAt(i)) {
                hint.append(secretWord.charAt(i));
            } else {
                hint.append("#");
            }
        }
        while (hint.length() < 15) {
            hint.append("#");
        }
        return hint.toString();
    }

    public String getSecretWord() {
        return secretWord;
    }
}
