package com.madhu.psds.strings;
//https://leetcode.com/problems/regular-expression-matching/
//10. Regular Expression Matching

public class RegularExpressionMatching {
    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
        System.out.println(regularExpressionMatching.isMatch(s,p));
    }

    public boolean isMatch(String s, String p) {
        char[] sChars = s.toCharArray(),pChars = p.toCharArray();
        int sLength = sChars.length,pLength = pChars.length;
        int sStart = 0,pStart=0;
        while (sStart < sLength && pStart < pLength) {
            if(pChars[pStart] == sChars[sStart]) {
                pStart++;
                sStart++;
            }
            else if(pChars[pStart] == '.') {
                pStart++;
                sStart++;
            } else {
                if(pStart < pLength && (pChars[pStart] == '*' || pChars[pStart+1] == '*')) {
                    pStart = pStart+2;
                    if(pStart >= pLength) return true;
                    while ( pStart < pLength && sStart < sLength && pChars[pStart]!=sChars[sStart]) sStart++;
                } else {
                    return false;
                }
            }
        }
        return sStart == sLength;
    }
}
