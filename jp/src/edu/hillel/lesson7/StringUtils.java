package edu.hillel.lesson7;

public class StringUtils {
    public int findSymbolOccurrence(String str, char symbol) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == symbol) {
                count++;
            }
        }
        return count;
    }

    public int findWordPosition(String source, String target) {
        int index = source.indexOf(target);
        return index;
    }

    public String stringReverse(String str) {
        StringBuilder reversed = new StringBuilder(str);
        reversed.reverse();
        return reversed.toString();
    }

    public boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
