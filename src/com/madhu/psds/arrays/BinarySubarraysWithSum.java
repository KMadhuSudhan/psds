package com.madhu.psds.arrays;

import java.util.HashMap;

public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
        BinarySubarraysWithSum binarySubarraysWithSum = new BinarySubarraysWithSum();
        System.out.println(binarySubarraysWithSum.numSubarraysWithSum(nums, 0));
    }

    public int numSubarraysWithSum(int[] A, int S) {
        if (A.length == 0) return 0;
        int count = 0;

        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int i, N = A.length;
        for (i = 0; i < N; i++) {
            sum += A[i];
            int freq = map.getOrDefault(sum - S, 0);
            count += freq;
            map.put(sum,  1 + map.getOrDefault(sum, 0));
        }
        return count;
    }
}
