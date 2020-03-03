package com.madhu.psds.arrays;
//https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/submissions/
//1218. Longest Arithmetic Subsequence of Given Difference

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence {
    public static void main(String[] args) {
        int[] nums = {1,5,7,8,5,3,4,2,1};
        LongestArithmeticSubsequence longestArithmeticSubsequence = new LongestArithmeticSubsequence();
        longestArithmeticSubsequence.longestSubsequence(nums,1);
    }

    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int x : arr) {
            int diff = x-difference;
            int freq = map.getOrDefault(diff, 0) + 1;
            map.put(x, freq);
            max = Math.max(max,freq);
        }
        return max;
    }
}
