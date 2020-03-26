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

    public String sortString(String s) {
        StringBuilder result = new StringBuilder();
        char[] sChars = s.toCharArray();

        Arrays.sort(sChars);
        int length = sChars.length;
        if(length == 0) return result.toString();
        boolean[] visited = new boolean[length];
        visited[0] = true;

        //increasing

        int visited_count = 0;
        while (true) {
            char prevChar = '.';
            int i =0;
            while (i<length) {
                if(sChars[i]!=prevChar && visited[i] == false) {
                    result.append(sChars[i]);
                    visited[i] = true;
                    visited_count++;
                }
                if(visited_count == length -1) break;
                prevChar = sChars[i];
                i++;
            }
            if(visited_count == length -1) break;
            char nextChar = '.';
            i = length -1;
            while (i>=0) {
                if(sChars[i]!=nextChar && visited[i] == false) {
                    result.append(sChars[i]);
                    visited[i] = true;
                    visited_count++;
                }
                if(visited_count == length -1) break;
                nextChar = sChars[i];
                i--;
            }
            if(visited_count == length -1) break;
        }


        //decreasing
//        prevChar = sChars[length-1];
//        for (int i=length-2;i>=0;i--) {
//            if(sChars[i]!=prevChar) {
//                result.append(sChars[i]);
//            }
//            prevChar = sChars[i];
//        }
        return result.toString();
    }
}
