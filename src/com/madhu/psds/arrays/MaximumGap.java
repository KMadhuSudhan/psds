package com.madhu.psds.arrays;
//https://leetcode.com/problems/maximum-gap/
//164. Maximum Gap

import java.util.Arrays;

public class MaximumGap {
    public static void main(String[] args) {
        int[] nums = {3,6,9,1};
        MaximumGap maximumGap = new MaximumGap();
        maximumGap.maximumGap(nums);
    }
    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        Arrays.sort(nums);
        int maxDiff = 0;
        for(int i=0;i<nums.length-1;i++) {
            maxDiff = Math.max(maxDiff,Math.abs(nums[i]-nums[i+1]));
        }
        return maxDiff;
    }
}
