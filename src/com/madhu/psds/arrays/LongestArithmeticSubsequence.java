package com.madhu.psds.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
    }

    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = arr.length;
        int max = 0;
        difference = Math.abs(difference);
        for (int i = 0; i < length; i++) {
            int diff = arr[i] - i * difference;
            int freq = map.getOrDefault(diff, 0);
            freq++;
            max = Math.max(max, freq);
            map.put(diff, freq);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            max = Math.max(max,entry.getValue());
        }
        return max;
    }
}
