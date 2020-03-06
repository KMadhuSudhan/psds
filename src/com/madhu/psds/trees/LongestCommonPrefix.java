package com.madhu.psds.trees;
//https://leetcode.com/problems/longest-common-prefix/
//14. Longest Common Prefix

public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] strs = {"flower","flow","flight"};
        longestCommonPrefix.longestCommonPrefix(strs);
    }
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if(length == 0) return "";
        int minLen = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs.length;i++) {
            minLen = Math.min(minLen,strs[i].length());
        }
        for (int i=0;i<minLen;i++) {
            char prefix = strs[0].charAt(i);
            for(int j=1;j<length;j++) {
                if(prefix!=strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(prefix);
        }
        return sb.toString();
    }
}
