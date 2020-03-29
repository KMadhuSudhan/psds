package com.madhu.psds.arrays;
//https://leetcode.com/problems/find-smallest-letter-greater-than-target/
//744. Find Smallest Letter Greater Than Target

public class FindSmallestLetter {
    public static void main(String[] args) {
        FindSmallestLetter findSmallestLetter = new FindSmallestLetter();
        char[] letters = {'c', 'f', 'j'};
        char target = 'a';
        System.out.println(findSmallestLetter.nextGreatestLetter(letters,target));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        for (char c: letters)
            if (c > target) return c;
        return letters[0];
    }
}
