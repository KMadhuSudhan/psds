package com.madhu.psds.arrays;
//https://leetcode.com/problems/longest-continuous-increasing-subsequence/submissions/
//674. Longest Continuous Increasing Subsequence

public class LongestContinuousIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,2,3,4,5};
        LongestContinuousIncreasingSubsequence longestContinuousIncreasingSubsequence = new LongestContinuousIncreasingSubsequence();
        int maxSize =  longestContinuousIncreasingSubsequence.findLengthOfLCIS(nums);
        System.out.print(maxSize);
    }

    public int findLengthOfLCIS(int[] nums) {
        int length = nums.length;
        if(length == 0) return 0;
        int maxSize = 1;
        int maxSoFar = 1;
        for (int i=0;i< length -1;i++) {
            if(nums[i  +1] > nums[i]) {
                maxSize++;
            } else {
                maxSize = 1;
            }
            if(maxSoFar < maxSize) maxSoFar = maxSize;
        }
        return maxSoFar;
    }
}
