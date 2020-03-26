package com.madhu.psds.strings;
//https://leetcode.com/problems/remove-palindromic-subsequences/
//1332. Remove Palindromic Subsequences

public class RemovePalindromic {
    public static void main(String[] args) {
        RemovePalindromic palindromic = new RemovePalindromic();
        String s = "ababa";
        palindromic.removePalindromeSub(s);
    }
    public int removePalindromeSub(String s) {
        int length = s.length();
        if(length == 0) return 0;
        if(isPalindrome(s)) return 1;
        return 2;
    }

    private boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length -1;
        while(start<end) {
            if(chars[start]!=chars[end]) return false;
            start++;
            end--;
        }
        return true;
    }
}
