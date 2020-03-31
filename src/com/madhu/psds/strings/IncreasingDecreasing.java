package com.madhu.psds.strings;
//https://leetcode.com/problems/increasing-decreasing-string/
//1370. Increasing Decreasing String

import java.util.Arrays;

public class IncreasingDecreasing {
    public static void main(String[] args) {
        String s = "aaaabbbbcccc";
        IncreasingDecreasing increasingDecreasing = new IncreasingDecreasing();
        System.out.println(increasingDecreasing.sortString(s));
    }

    //
    public String sortStringWithOutRecursion(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) arr[c - 'a']++;
        StringBuilder sb = new StringBuilder();

        while (sb.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (arr[i] > 0) {
                    sb.append((char) (i + 'a'));
                    arr[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (arr[i] > 0) {
                    sb.append((char) (i + 'a'));
                    arr[i]--;
                }
            }
        }
        return sb.toString();
    }

    public String sortString(String s) {
        StringBuilder result = new StringBuilder();
        char[] sChars = s.toCharArray();
        Arrays.sort(sChars);
        int length = sChars.length;
        if (length == 0) return result.toString();
        boolean[] visited = new boolean[length];
        sortString(sChars, result, visited, length,1);
        return result.toString();
    }

    public void sortString(char[] sChars, StringBuilder result, boolean[] visited, int length,int visitedCount) {
        //increasing
        if(visitedCount == 0) return;
        char prevChar = '.';
        int i = 0;
        visitedCount =0;
        while (i < length) {
            if(visited[i]) {
                i++;
                continue;
            }
            if (sChars[i] != prevChar) {
                result.append(sChars[i]);
                visited[i] = true;
                visitedCount++;
            }
            prevChar = sChars[i];
            i++;
        }
        char nextChar = '.';
        i = length - 1;
        while (i >= 0) {
            if(visited[i]) {
                i--;
                continue;
            }
            if (sChars[i] != nextChar) {
                result.append(sChars[i]);
                visited[i] = true;
                visitedCount++;
            }
            nextChar = sChars[i];
            i--;
        }
        sortString(sChars,result,visited,length,visitedCount);
    }
}
