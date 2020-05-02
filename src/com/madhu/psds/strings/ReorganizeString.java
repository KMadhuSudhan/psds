package com.madhu.psds.strings;
//https://leetcode.com/problems/reorganize-string/
//767. Reorganize String

import java.util.Arrays;

public class ReorganizeString {
    public static void main(String[] args) {
        String str = "aaab";
        ReorganizeString reorganizeString = new ReorganizeString();
        System.out.println(reorganizeString.reorganizeString(str));
    }

    public String reorganizeString(String S) {
        int n = S.length();

        // Populate arr with char vs count
        int[][] arr = new int[26][2];
        for (char ch: S.toCharArray()) {
            arr[ch - 'a'][0] = ch;
            arr[ch - 'a'][1]++;

            if (arr[ch - 'a'][1] > (n+1)/2) return "";
        }

        // Sort desc by count
        Arrays.sort(arr, (a, b) -> b[1] - a[1]);

        // Populate result array, starting from index 0 and populating every other character.
        // When index hits the end of the array, set index to 1 and continue
        // Eg. for [[v, 3], [l, 1], [o, 1]], it would go as follows:
        // ['v', ' ', ' ', ' ', ' ']
        // ['v', ' ', 'v', ' ', ' ']
        // ['v', ' ', 'v', ' ', 'v']
        // ['v', 'l', 'v', ' ', 'v']
        // ['v', 'l', 'v', 'o', 'v']
        char[] result = new char[n];
        int index = 0;
        for (int i = 0; i < 26; i++) {
            while(arr[i][1]-- > 0) {
                result[index] = (char)arr[i][0];
                index += 2;
                if (index > n - 1) index = 1;
            }
        }

        return new String(result);
    }
}
