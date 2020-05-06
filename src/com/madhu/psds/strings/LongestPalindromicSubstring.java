package com.madhu.psds.strings;
//https://leetcode.com/problems/longest-palindromic-substring/
//5. Longest Palindromic Substring

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        longestPalindromicSubstring.longestPalindrome(s);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        char[] schars = s.toCharArray();
        int length = schars.length, start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            int len1 = expandAroundCenter(schars, i, i);
            int len2 = expandAroundCenter(schars, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    int expandAroundCenter(char[] schars, int left, int right) {
        while (left >= 0 && right < schars.length && schars[left] == schars[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
