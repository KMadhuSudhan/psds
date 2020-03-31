package com.madhu.psds.strings;
//https://leetcode.com/problems/most-common-word/
//819. Most Common Word

import java.util.*;

public class MostCommonWord {
    public static void main(String[] args) {
        String str = "Bob. hIt, baLl";
        MostCommonWord mostCommonWord = new MostCommonWord();
        String[] banned = {"bob","hit"};
        System.out.println( mostCommonWord.mostCommonWord(str,banned));
    }
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String,Integer> map = new HashMap<>();
        String[] words = paragraph.replaceAll("!", "")
                .replaceAll("\\?", " ")
                .replaceAll("'", " ")
                .replaceAll(",", " ")
                .replaceAll(";", " ")
                .replaceAll("\\.", " ")
                .toLowerCase()
                .replaceAll("\\s+", " ")
                .split(" ");

        for (String word: words) {
            int freq = map.getOrDefault(word,0);
            map.put(word,freq+1);
        }
        for (int i=0;i<banned.length;i++) {
            if(map.containsKey(banned[i])) map.remove(banned[i]);
        }
        int maxCount = 0;
        String mostFreq = "";
        for (Map.Entry<String,Integer> entry: map.entrySet()) {
            int val = entry.getValue();
            if(maxCount < val) {
                maxCount = val;
                mostFreq = entry.getKey();
            }
        }
        return mostFreq;
    }
}
