package com.madhu.psds.strings;

import java.util.HashMap;
import java.util.Map;

public class FormWordsUsingChar {
    public static void main(String[] args) {
        String[] words = new String[]{"cat", "bt", "hat", "tree"};
        String chars = "atach";
        FormWordsUsingChar formWordsUsingChar = new FormWordsUsingChar();
        formWordsUsingChar.countCharacters(words, chars);
    }

    public int countCharacters(String[] words, String str) {
        int wordCount = 0;
        char[] chars = str.toCharArray();
        Map<Character, Integer> charCount = new HashMap();
        for (char eachChar : chars) {
            int count = charCount.getOrDefault(eachChar, 0);
            charCount.put(eachChar, count + 1);
        }
        for (String word : words) {
            char[] allChars = word.toCharArray();
            boolean wordCanForm = true;
            for (char eachChar : allChars) {
                if (!charCount.containsKey(eachChar)) {
                    wordCanForm = false;
                    break;
                }
            }
            if (wordCanForm){
                wordCount+=word.length();
            }
        }
        return wordCount;
    }
}
