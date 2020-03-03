package com.madhu.psds.arrays;
//https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
//1365. How Many Numbers Are Smaller Than the Current Number

public class NumbersSmallerThanN {
    public static void main(String[] args) {
        NumbersSmallerThanN numbersSmallerThanN = new NumbersSmallerThanN();
        int[] nums = {8,1,2,2,3};
        numbersSmallerThanN.smallerNumbersThanCurrent(nums);
    }
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int[] res = new int[nums.length];

        for (int i =0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        for (int i = 1 ; i <= 100; i++) {
            count[i] += count[i-1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                res[i] = 0;
            else
                res[i] = count[nums[i] - 1];
        }
        return res;
    }
}
