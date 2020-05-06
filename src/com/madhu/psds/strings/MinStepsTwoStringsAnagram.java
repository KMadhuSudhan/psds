package com.madhu.psds.strings;
//https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
//1347. Minimum Number of Steps to Make Two Strings Anagram

public class MinStepsTwoStringsAnagram {
    public static void main(String[] args) {
        String s = "bab";
        String t = "aba";
        MinStepsTwoStringsAnagram minStepsTwoStringsAnagram = new MinStepsTwoStringsAnagram();
        minStepsTwoStringsAnagram.minSteps(s,t);
    }
    public int minSteps(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int ans =0;
        int[] countArray = new int[26];
        for(int i=0;i<sChars.length;i++) {
            countArray[tChars[i] - 'a']++;
            countArray[sChars[i] - 'a']--;
        }
        for(int i=0;i<26;i++) {
            if(countArray[i]>0) {
                ans+=countArray[i];
            }
        }
        return ans;
    }
}
