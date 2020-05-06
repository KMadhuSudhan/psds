package com.madhu.psds.strings;
//https://leetcode.com/problems/palindromic-substrings/
//647. Palindromic Substrings

public class PalindromicSubstrings {
    public static void main(String[] args) {
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        palindromicSubstrings.countSubstrings("abc");
    }
    public int countSubstrings(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++){
            count +=  pali(s, i, i);
            count +=  pali(s, i, i+1);
        }
        return count;
    }
    int pali(String s, int l, int r){
        int size = 0;
        while(l>=0 && r < s.length() && s.charAt(l--) == s.charAt(r++)) size++;
        return size;
    }
}
