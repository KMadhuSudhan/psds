package com.madhu.psds.strings;
//https://leetcode.com/problems/repeated-substring-pattern/submissions/
//459. Repeated Substring Pattern

public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        String str = "abaababaab";
        RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern(str));
    }
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int i = 0;
        int j = i + 1;
        String substring = null;
        char[] chars = s.toCharArray();
        while(i < n) {
            while(j < n && chars[i] != chars[j]) {
                j++;
            }
            int len = (j - i);
            if(j + len > n)
                return false;
            String str1 = s.substring(i, len);
            String str2 = s.substring(j, j + len);

            if(str1.equals(str2)) {
                substring = str1;
                if(canBeFormed(s, substring, n))
                    return true;
                else
                    j++;
            } else {
                j++;
            }
            if(j == n)
                return false;
        }

        return canBeFormed(s, substring, n);
    }

    private boolean canBeFormed(String s, String substring, int n) {
        if(n % substring.length() != 0)
            return false;
        int nTimes = n / substring.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nTimes; i++) {
            sb.append(substring);
        }

        if(sb.toString().equals(s))
            return true;
        else
            return false;
    }
}
