package com.madhu.psds.strings;
//https://leetcode.com/problems/longest-word-in-dictionary/
//720. Longest Word in Dictionary

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary {
    public static void main(String[] args) {
        String[] s = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        LongestWordInDictionary longestWordInDictionary = new LongestWordInDictionary();
        longestWordInDictionary.longestWord(s);

    }
    public String longestWord(String[] words) {
        Arrays.sort(words, (o1, o2) -> {
            if(o1.length() == o2.length()){
                return  o2.compareTo(o1);
            }
            return new Integer(o1.length()).compareTo(o2.length());
        });

        String out = "";
        Set<String> prefixes = new HashSet<>();
        for (String word:words) {
            if(word.length() ==1 || prefixes.contains(word.substring(0,word.length()-1)) ){
                prefixes.add(word);
                if(out.length() <= word.length()) out = word;
            }
        }
        return out;
    }
}
