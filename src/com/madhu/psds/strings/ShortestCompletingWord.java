package com.madhu.psds.strings;
//https://leetcode.com/problems/shortest-completing-word
//748. Shortest Completing Word

public class ShortestCompletingWord {
    public static void main(String[] args) {
        ShortestCompletingWord shortestCompletingWord = new ShortestCompletingWord();
        String[] words = {"looks","pest","stew","show"};
        System.out.println(shortestCompletingWord.shortestCompletingWord("1s3 456",words));
    }
    public String shortestCompletingWord(String licensePlate, String[] words) {
        char[] licenceChars = licensePlate.toCharArray();
        int licenceCharsLength = licenceChars.length;
        int[] countArr = new int[26];
        for (int i=0;i<licenceCharsLength;i++) {
            if(licenceChars[i] >= 65 && licenceChars[i] <= 90) {
                countArr[licenceChars[i] + 32 - 'a']++;
            } else if(licenceChars[i]>= 97 && licenceChars[i]<= 122) {
                countArr[licenceChars[i] - 'a']++;
            }
        }

        int minLength = Integer.MAX_VALUE;
        String result = "";
        for (String word: words) {
            int[] countArrayCopy = countArr.clone();
            char[] wordChars = word.toCharArray();
            int wordLength = wordChars.length;
            for(int i=0;i<wordLength;i++) {
                countArrayCopy[wordChars[i] - 'a']--;
            }
            boolean anyCharactersRemaining = false;
            for (int i=0;i<countArrayCopy.length;i++) {
                if(countArrayCopy[i] > 0) {
                    anyCharactersRemaining = true;
                    break;
                }
            }
            if(!anyCharactersRemaining && wordLength < minLength) {
                result = word;
                minLength = wordLength;
            }
        }
        return result;
    }
}
