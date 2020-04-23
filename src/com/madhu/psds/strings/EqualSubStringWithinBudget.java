package com.madhu.psds.strings;
//https://leetcode.com/problems/get-equal-substrings-within-budget
//1208. Get Equal Substrings Within Budget

public class EqualSubStringWithinBudget {
    public static void main(String[] args) {
        EqualSubStringWithinBudget equalSubStringWithinBudget = new EqualSubStringWithinBudget();
        String s = "abcd";
        String t = "cdef";
        int maxCost = 3;
        System.out.println(equalSubStringWithinBudget.equalSubstring(s,t,maxCost));
    }
    public int equalSubstring(String s, String t, int maxCost) {
        int length = 0,maxLength = 0,low = 0,high = 0;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int strLength = sChars.length;
        while( high < strLength) {
            int charDiff = Math.abs(tChars[high] - sChars[high]);
            if(charDiff<=maxCost) {
                length++;
                maxCost-=charDiff;
                high++;
                maxLength = Math.max(maxLength,length);
            } else {
                int diff = Math.abs(tChars[low] - sChars[low]);
                maxCost+=diff;
                length--;
                low++;
            }
        }
        maxLength = Math.max(maxLength,length);
        return maxLength;
    }
}
