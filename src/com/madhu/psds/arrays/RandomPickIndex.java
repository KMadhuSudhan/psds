package com.madhu.psds.arrays;

import java.util.*;

public class RandomPickIndex {
    Map<Integer, List<Integer>> targets = new HashMap<>();
    Random r = new Random();
    public RandomPickIndex(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            targets.computeIfAbsent(nums[i], k -> new ArrayList()).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> list = targets.get(target);
        return list.get(r.nextInt(list.size()));
    }
}
