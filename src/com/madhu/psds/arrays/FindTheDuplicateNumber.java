package com.madhu.psds.arrays;
//https://leetcode.com/problems/find-the-duplicate-number/
//287. Find the Duplicate Number

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        FindTheDuplicateNumber findTheDuplicateNumber = new FindTheDuplicateNumber();
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findTheDuplicateNumber.findDuplicate(nums));
    }

    public int findDuplicate(int[] nums) {
        int length = nums.length;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (nums[Math.abs(nums[i])] < 0) return Math.abs(nums[i]);
            nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
        }
        return result;
    }
}
