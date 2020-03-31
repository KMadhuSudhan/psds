package com.madhu.psds.strings;
//https://leetcode.com/problems/compare-version-numbers/
//165. Compare Version Numbers

public class CompareVersion {
    public static void main(String[] args) {
        String version1 = "1.0";
        String version2 = "1";
        CompareVersion compareVersion = new CompareVersion();
        System.out.println(compareVersion.compareVersion(version1,version2));
    }

    public int compareVersion(String version1, String version2) {
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");
        int len1 = strs1.length, len2 = strs2.length;
        int maxLen = len1 > len2 ? len1 : len2;
        for (int i=0; i<maxLen; i++) {
            int str1 = len1 > i ? Integer.parseInt(strs1[i]) : 0, str2 = len2 > i ? Integer.parseInt(strs2[i]) : 0;
            if (str1 > str2) return 1;
            if (str1 < str2) return -1;
        }
        return 0;
    }
}
