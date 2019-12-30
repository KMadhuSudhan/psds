package com.madhu.psds.strings;

public class ReverseWords {
    public static void main(String[] args) {
        String sentence = "Let's take LeetCode contest";
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords(sentence));
    }

    public String reverseWords(String s) {
        String[] wordsArray = s.split(" ");
        int length = wordsArray.length;
        for (int i = 0; i < length; i++) {
            wordsArray[i] = reverse(wordsArray[i].trim());
        }
        return String.join(" ",wordsArray);
    }

    public String reverse(String s) {
        char[] word = s.toCharArray();
        int i = 0, j = word.length - 1;
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(word);
    }
}
