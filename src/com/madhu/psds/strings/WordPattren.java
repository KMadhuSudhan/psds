package com.madhu.psds.strings;
//https://leetcode.com/problems/word-pattern/
//290. Word Pattern

import java.util.HashMap;
import java.util.Map;

public class WordPattren {
    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog dog dog dog";
        WordPattren wordPattren = new WordPattren();
        System.out.println(wordPattren.wordPattern(pattern, str));
    }

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i = 0; i < words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }

    public boolean wordPatternMap(String pattern, String str) {
        char[] patternChars = pattern.toCharArray();
        String[] words = str.split(" ");
        int patternLength = patternChars.length, wordsLength = words.length;
        if (patternLength != wordsLength) return false;

        Map<Character, String> mapping = new HashMap<>();
        Map<String, Character> reverseMapping = new HashMap<>();

        for (int i = 0; i < patternLength; i++) {
            if (mapping.containsKey(patternChars[i])) {
                if (!mapping.get(patternChars[i]).equals(words[i])) return false;
            } else {
                if (reverseMapping.containsKey(words[i])) return false;
                reverseMapping.put(words[i], patternChars[i]);
                mapping.put(patternChars[i], words[i]);
            }
        }
        return true;
    }
}
