package com.madhu.psds.strings;

import java.util.ArrayList;
import java.util.List;

public class ReverseWords {
    public static void main(String[] args) {
        String sentence = "Let's take LeetCode contest";
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords(sentence));
    }

    public String reverseWords(String s) {
        String input = s.trim();
        String[] words = input.split(" ");
        List<String> newWords = new ArrayList();

        for(int i=0;i<words.length;i++) {
            if(words[i].length() == 0) continue;
            newWords.add(words[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=newWords.size()-1;i>0;i--) {
            sb.append(newWords.get(i));
            sb.append(" ");
        }
        if(newWords.size() > 0 && newWords.get(0).length() > 0) sb.append(newWords.get(0));
        return sb.toString();
    }
}
