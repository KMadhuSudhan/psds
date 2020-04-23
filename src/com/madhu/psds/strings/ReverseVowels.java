package com.madhu.psds.strings;
//https://leetcode.com/problems/reverse-vowels-of-a-string/
//345. Reverse Vowels of a String

public class ReverseVowels {
    public static void main(String[] args) {
        String str = "hello";
        ReverseVowels reverseVowels = new ReverseVowels();
        System.out.println(reverseVowels.reverseVowels(str));
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int low = 0;
        int high = chars.length - 1;
        while (low < high) {
            while (low<high && !isVowel(chars[low])) { // 'a','e','i','o','u'
                low++;
            }
            while (high > low && !isVowel(chars[high])) {
                high--;
            }
            if(low > high) break;
            if(chars[low]!=chars[high]) swap(chars, low,high);
            low++;
            high--;
        }
        return new String(chars);
    }

    void swap(char[] chars,int low,int high) {
        char temp = chars[low];
        chars[low] = chars[high];
        chars[high] = temp;
    }

    boolean isVowel(char character) {
        switch (character) {
            case 'a':
                return true;
            case 'e':
                return true;
            case 'i':
                return true;
            case 'o':
                return true;
            case 'u':
                return true;
            case 'A':
                return true;
            case 'E':
                return true;
            case 'I':
                return true;
            case 'O':
                return true;
            case 'U':
                return true;
            default:
                return false;
        }
    }
}
