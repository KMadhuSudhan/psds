package com.madhu.psds.strings;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int length = s.length();
        int longest = 1;
        char[] charArr = s.toCharArray();
        for(int i=1;i<length;i++) {
            int x = i-1;
            int y = i;
            int strlength = 0;
            while(x>=0 && y < length && charArr[x] == charArr[y]) {
                strlength = strlength + 2;
                x--;
                y++;
            }
            longest = Math.max(strlength,longest);
            strlength = 1;
            x = i-1;
            y = i+1;
            while(x>=0 && y < length && charArr[x] == charArr[y]) {
                strlength = strlength + 2;
                x--;
                y++;
            }
            longest = Math.max(strlength,longest);
        }
        return longest;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        longestPalindrome.longestPalindrome(s);
    }

}
