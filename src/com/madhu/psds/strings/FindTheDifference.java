package com.madhu.psds.strings;

public class FindTheDifference {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        FindTheDifference findTheDifference = new FindTheDifference();
        findTheDifference.findTheDifference(s, t);
    }

    public char findTheDifference(String s, String t) {
        int length = s.length();
        int res = 0;
        int i;
        for (i = 0; i < length; i++) {
            res ^= s.charAt(i) ^ t.charAt(i);
        }
        res = res ^ t.charAt(i);
        return (char) res;
    }
}
