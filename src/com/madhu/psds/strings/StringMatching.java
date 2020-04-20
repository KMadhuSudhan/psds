package com.madhu.psds.strings;
//https://leetcode.com/problems/string-matching-in-an-array/
//1408. String Matching in an Array

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringMatching {
    public static void main(String[] args) {
        String[] words = {"mass","as","hero","superhero"};
        StringMatching stringMatching = new StringMatching();
        stringMatching.stringMatching(words);
    }
    public List<String> stringMatching(String[] words) {
        Set<String> set = new HashSet<String>();
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words.length; j++) {
                if(words[j].contains(words[i]) && i!=j) {
                    set.add(words[i]);
                }
            }
        }
        return new ArrayList<String>(set);
    }
}
