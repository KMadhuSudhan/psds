package com.madhu.psds.arrays;
//https://leetcode.com/problems/first-missing-positive/
//41. First Missing Positive

import java.util.HashMap;
import java.util.Map;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int i = 0;
        while (i < length) {
            if (nums[i] > 0 && nums[i] <= length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        for (i = 0; i < length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }

    public int firstMissingPositiveMap(int[] nums) {
        int length = nums.length;
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (i < length) {
            int count = map.getOrDefault(nums[i], 0);
            count++;
            map.put(nums[i], count);
            i++;
        }
        for (i = 1; i <=length; i++) {
            if(map.get(i) == null) return i;
        }
        return i;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
