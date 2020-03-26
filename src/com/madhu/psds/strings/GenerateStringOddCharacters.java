package com.madhu.psds.strings;
//https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/
//1374. Generate a String With Characters That Have Odd Counts

public class GenerateStringOddCharacters {
    public static void main(String[] args) {
        GenerateStringOddCharacters generateStringOddCharacters = new GenerateStringOddCharacters();
        generateStringOddCharacters.generateTheString(4);
    }
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) {
            for (int i = 0; i < n - 1; i++) {
                sb.append('a');
            }
            sb.append('b');
        } else {
            for (int i = 0; i < n; i++) {
                sb.append('a');
            }
        }
        return sb.toString();
    }
}
