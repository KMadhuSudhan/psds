package com.madhu.psds.strings;
//https://leetcode.com/problems/longest-common-subsequence/
//1143. Longest Common Subsequence

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        longestCommonSubsequence.longestCommonSubsequence(str1,str2);
    }

    public int longestCommonSubsequence(String text1, String text2) {
         char[] text1Char = text1.toCharArray(),text2Char = text2.toCharArray();
         int text1Length = text1Char.length,text2Length = text2Char.length;
        int[][] dp = new int[text1Length+1][text2Length+1];
        for(int i=1;i<=text1Length;i++) {
            for (int j=1;j<=text2Length;j++) {
                if(text1Char[i-1] == text2Char[j-1]) {
                    dp[i][j] += dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] += Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[text1Length][text2Length];
    }
}
