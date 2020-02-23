package com.madhu.psds.strings;
//https://leetcode.com/problems/longest-palindrome/
//409. Longest Palindrome

public class LongestPalindromeCanBuild {
    public int longestPalindrome(String s) {
        char[] sChar = s.toCharArray();
        int[] alphabet = new int[256];
        int count = 0;
        for(int i = 0; i < sChar.length; i++)
            if(++alphabet[sChar[i]] % 2 == 0)
                count += 2;
        return (sChar.length - count != 0) ? count + 1 : count;
    }

    public static void main(String[] args) {
        String Str = "abccccdd";
        LongestPalindromeCanBuild longestPalindromeCanBuild = new LongestPalindromeCanBuild();
        longestPalindromeCanBuild.longestPalindrome(Str);
    }
}
