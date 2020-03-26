package com.madhu.psds.strings;
//https://leetcode.com/problems/verifying-an-alien-dictionary
//953. Verifying an Alien Dictionary

public class IsAlienSorted {
    public static void main(String[] args) {
        IsAlienSorted isAlienSorted = new IsAlienSorted();
        String[] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        isAlienSorted.isAlienSorted(words,order);
    }

    public boolean isAlienSorted(String[] words, String order) {
        int wordsLength = words.length;
        for (int i=0;i<wordsLength-1;i++) {
            char[] firstWordChars = words[i].toCharArray();
            char[] secondWordChars = words[i+1].toCharArray();
            int firstwordLength = firstWordChars.length;
            int secondWordLength = secondWordChars.length;
            Character firstWordCharacter = null;
            Character secondWordCharacter = null;
            for(int j=0;j<Math.min(firstwordLength,secondWordLength);j++) {
                firstWordCharacter = firstWordChars[j];
                secondWordCharacter = secondWordChars[j];
                if(firstWordCharacter!=secondWordCharacter) break;
            }
            if(firstWordCharacter == secondWordCharacter && secondWordLength < firstwordLength) return false;
            if(order.indexOf(firstWordCharacter) > order.indexOf(secondWordCharacter)) return false;
        }
        return true;
    }
}
