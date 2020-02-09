package com.madhu.psds.strings;

public class KMPSearch {
    public static void main(String[] args) {
        String str = "ababcabcabababd";
        String pattern = "acbacdabcy";
        KMPSearch kmpSearch = new KMPSearch();
        kmpSearch.search(str, pattern);
    }

    public void search(String str, String pattern) {
        char[] strChars = str.toCharArray();
        char[] patternCars = pattern.toCharArray();

        int patternLength = pattern.length();
        int strLength = str.length();

        int[] patternTable = new int[patternLength];

        int i = 0;
        int j = 1;
        while (j < patternLength) {
            if (patternCars[i] == patternCars[j]) {
                patternTable[j] = i + 1;
                i++;
                j++;
            } else if (i != 0) {
                i = patternTable[i - 1];
            } else {
                j++;
            }
        }

        i=0;
        j=0;
        int startindex = 0;
        while (i<strLength && j < patternLength) {
            System.out.println("i,j " + i + "," + j);
           if(strChars[i] == patternCars[j]) {
               i++;
               j++;
           } else if(j!=0) {
               j = patternTable[j-1];
           } else {
               i++;
               startindex = i;
           }
        }
        System.out.println("sTARTING INDEX + "  + startindex);
    }
}
