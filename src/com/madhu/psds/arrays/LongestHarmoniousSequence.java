package com.madhu.psds.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSequence {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        LongestHarmoniousSequence longestHarmoniousSequence = new LongestHarmoniousSequence();
        longestHarmoniousSequence.findLHS(nums);
    }

    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i] + 1)) {
                max = Math.max(max, map.get(nums[i]) + map.get(nums[i] + 1));
            }
        }
        return max;
    }
}
