package com.madhu.psds.strings;

public class KMPSearch {
    public static void main(String[] args) {
        String str = "ababcabcabababd";
        String pattern = "abcbabca";
        KMPSearch kmpSearch = new KMPSearch();
        kmpSearch.search(str, pattern);
    }

    public void search(String str, String pattern) {
        char[] strChars = str.toCharArray();
        char[] patternChars = pattern.toCharArray();

        int patternLength = pattern.length();
        int strLength = str.length();

        int[] patternTable = new int[patternLength];

        int i = 0;
        int j = 1;
        while (j < patternLength) {
            if (patternChars[i] == patternChars[j]) {
                patternTable[j] = i + 1;
                i++;
                j++;
            } else if (i != 0) {
                i = patternTable[i - 1];
            } else {
                j++;
            }
        }

        for(i=0;i<patternTable.length;i++) {
            System.out.print(" " + patternTable[i]);
        }

        i=0;
        j=0;
        int startIndex = 0;
        while (i<strLength && j < patternLength) {
            System.out.println("i,j " + i + "," + j);
           if(strChars[i] == patternChars[j]) {
               i++;
               j++;
           } else if(j!=0) {
               j = patternTable[j-1];
           } else {
               i++;
               startIndex = i;
           }
        }
        System.out.println("STARTING INDEX: "  + startIndex);
    }
}
