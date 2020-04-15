package com.madhu.psds.arrays;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/contiguous-array/
//525. Contiguous Array

public class ContiguousArray {
    public static void main(String[] args) {
        ContiguousArray contiguousArray = new ContiguousArray();
        int[] nums = {0,0,1,0,0,0,1,1};
        System.out.println(contiguousArray.findMaxLength(nums));
    }
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }
}
