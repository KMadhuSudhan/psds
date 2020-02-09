package com.madhu.psds.strings;

public class RabinKarpSearch {
    private int prime = 101;

    public static void main(String[] args) {
        String str = "AABAACAADAABAABA";
        String pattern = "AABA";
        RabinKarpSearch rabinKarpSearch = new RabinKarpSearch();
        rabinKarpSearch.patternSearch(str.toCharArray(),pattern.toCharArray());
    }
    public int patternSearch(char[] text, char[] pattern) {
        int patternLength = pattern.length;
        int textLength = text.length;
        long patternHash = createHash(pattern,patternLength-1);
        long textHash = createHash(text,patternLength -1);
        for(int i =1;i<textLength;i++) {
            if(patternHash == textHash && checkEqual(text, i - 1, i + patternLength - 2, pattern, 0, patternLength - 1)) {
                return i - 1;
            }
            if(i < textLength - patternLength + 1) {
                textHash = recalculateHash(text, i - 1, i + patternLength - 1, textHash, patternLength);
            }
        }
        return -1;
    }

    private long recalculateHash(char[] str,int oldIndex, int newIndex,long oldHash, int patternLen) {
        long newHash = oldHash - str[oldIndex];
        newHash = newHash/prime;
        newHash += str[newIndex]*Math.pow(prime, patternLen - 1);
        return newHash;
    }

    private boolean checkEqual(char str1[],int start1,int end1, char str2[],int start2,int end2){
        if(end1 - start1 != end2 - start2) {
            return false;
        }
        while(start1 <= end1 && start2 <= end2){
            if(str1[start1] != str2[start2]){
                return false;
            }
            start1++;
            start2++;
        }
        return true;
    }

    private long createHash(char[] str, int end){
        long hash = 0;
        for (int i = 0 ; i <= end; i++) {
            hash += str[i]*Math.pow(prime,i);
        }
        return hash;
    }
}