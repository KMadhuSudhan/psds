package com.madhu.psds.strings;
//https://leetcode.com/problems/custom-sort-string
//791. Custom Sort String

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
    public static void main(String[] args) {
        String S = "kqep";
        String T = "pekeq";
        CustomSortString customSortString = new CustomSortString();
        System.out.println(customSortString.customSortString(S,T));
    }

    public String customSortString(String S, String T) {
        char[] schars = S.toCharArray();
        char[] tchars = T.toCharArray();
        int sLength = schars.length;
        int tLength = tchars.length;

        int[] intMap = new int[26];
        int[] charMap = new int[26];
        boolean[] existance = new boolean[26];

        for (int i=0;i<sLength;i++) {
            intMap[schars[i] - 'a'] = i;
            existance[schars[i] - 'a'] = true;
        }

        int start = 0;
        char[] result = new char[tLength];

        for (int i=0;i<tLength;i++) {
            int index =  tchars[i] - 'a';
            if(existance[index]) {
                int mapping = intMap[index];
                charMap[mapping]++;
            } else {
                result[start++] = tchars[i];
            }
        }

        for(int i=0;i<26;i++) {
            int count = charMap[i];
            while (count-->0) {
                result[start++] = (char) ('a' + intMap[i]);
            }
        }

        return new String(result);
    }

    public String customSortStringNotRefactor(String S, String T) {
        char[] schars = S.toCharArray();
        char[] tchars = T.toCharArray();
        int sLength = schars.length;
        int tLength = tchars.length;
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<sLength;i++) {
            map.put(schars[i],i);
        }

        int[] charMap = new int[26];
        int start = 0;
        char[] result = new char[tLength];
        for(int i=0;i<tLength;i++) {
            if(map.containsKey(tchars[i])){
                charMap[map.get(tchars[i])]++;
            } else {
                result[start++] = tchars[i];
            }
        }

        for (int i=0;i<sLength;i++) {
            int count = charMap[map.get(schars[i])];
            while (count > 0) {
                result[start++] = schars[i];
                count--;
            }
        }
        return new String(result);
    }
}
