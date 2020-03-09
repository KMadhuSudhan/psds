package com.madhu.psds.strings;
//https://leetcode.com/problems/rotate-string/
//796. Rotate String

public class RotateString {
    public static void main(String[] args) {
        String A = "bbbacddceeb";
        String B = "ceebbbbacdd";
        RotateString rotateString = new RotateString();
        System.out.println(rotateString.compareStrings(A, B));
    }

    ///rotate untill to its length
    public boolean rotateString(String A, String B) {
        int length = A.length();
        char[] characters = A.toCharArray();
        if (A.equals(B)) return true;
        int rotation = 0;
        while (rotation < length) {
            char temp = characters[0];
            int i = 1;
            while (i < length) {
                characters[i - 1] = characters[i];
                i++;
            }
            characters[i - 1] = temp;
            if (B.equals(new String(characters))) return true;
            rotation++;
        }
        return false;
    }

    public boolean compareStrings(String A, String B) {
        if (A.equals(B)) return true;
        int alength = A.length();
        int blength = B.length();
        if (alength != blength) return false;
        char[] characters = A.toCharArray();
        char[] copyArray = characters.clone();
        char bFirstChar = B.charAt(0);
        int i = 0;
        while (i < alength) {
            while (i < alength && bFirstChar != characters[i]) {
                i++;
            }
            if (i == alength) return false;
            reverseString(characters, 0, i - 1);
            reverseString(characters, i, alength - 1);
            reverseString(characters, 0, alength - 1);
            if (B.equals(new String(characters))) return true;
            characters = copyArray.clone();
            i++;
        }
        return false;
    }

    public void reverseString(char[] characters, int start, int end) {
        while (start < end) {
            char temp = characters[start];
            characters[start] = characters[end];
            characters[end] = temp;
            start++;
            end--;
        }
    }
}
