package com.madhu.psds.strings;

public class LongestUnCommonSubsequence {
    public static void main(String[] args) {
        String a = "aba";
        String b = "aba";
        LongestUnCommonSubsequence longestUnCommonSubsequence = new LongestUnCommonSubsequence();
        longestUnCommonSubsequence.findLUSlength(a,b);
    }
    public int findLUSlength(String a, String b) {
        int u=0;
        if(a.equals(b)) {
            u=-1;
        }
        else {
            u=(int)Math.max(a.length(),b.length());
        }
        return u;
    }
}
