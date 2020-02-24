package com.madhu.psds.arrays;
//https://leetcode.com/problems/permutation-in-string/
//567. Permutation in String

public class PermutationInAString {
    public static void main(String[] args) {
        PermutationInAString permutationInAString = new PermutationInAString();
        String s1= "ab";
        String s2 = "eidboaoo";
        permutationInAString.checkInclusion(s1,s2);
    }

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int left = 0, right = 0;

        if (len1 > len2) return false;

        int[] arr = new int[26];

        for(int i = 0; i < len1; i++) {
            arr[s1.charAt(i) - 'a']++;
        }

        while(right < len2) {
            int index = s2.charAt(right) - 'a';

            if(arr[index] > 0) {
                arr[index]--;
                right++;
            } else {
                arr[s2.charAt(left) - 'a']++;
                left++;
            }

            if(right - left == len1) {
                return true;
            }
        }

        return false;
    }

}
