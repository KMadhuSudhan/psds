package com.madhu.psds.arrays;

import java.util.HashMap;
import java.util.Map;

public class KdiffPairs {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 4, 1, 5};
        int k = 2;
        KdiffPairs kdiffPairs = new KdiffPairs();
        System.out.println(kdiffPairs.findPairs(nums, k));
    }

    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k<0) return 0;
        int count = 0;
        Map<Integer, Integer> diffMap = new HashMap();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int rCount = diffMap.getOrDefault(nums[i], 0);
            diffMap.put(nums[i], rCount + 1);
        }
        for (Map.Entry<Integer, Integer> entry : diffMap.entrySet()) {
            int key = entry.getKey();
            if (k != 0 && diffMap.containsKey(k + key)) {
                count++;
            }
            if (k == 0 && entry.getValue() >= 2) count++;
        }

        return count;
    }
}