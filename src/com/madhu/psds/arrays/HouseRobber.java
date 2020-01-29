package com.madhu.psds.arrays;

//198. https://leetcode.com/problems/house-robber/
public class HouseRobber {
    public static void main(String[] args) {
        int[] houses = {1, 2, 3, 1};
        HouseRobber houseRobber = new HouseRobber();
        houseRobber.rob(houses);
    }

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        int value1 = nums[0];
        if (length == 1) return nums[0];
        int value2 = Math.max(nums[0], nums[1]);
        if (length == 2) return value2;
        int max = 0;
        for (int i = 2; i < length; i++) {
            max = Math.max(value1 + nums[i], value2);
            value1 = value2;
            value2 = max;
        }
        return max;
    }
}
