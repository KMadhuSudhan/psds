package com.madhu.psds.arrays;
//https://leetcode.com/problems/max-consecutive-ones/
//485. Max Consecutive Ones

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,0,1,1,1};
        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        maxConsecutiveOnes.findMaxConsecutiveOnes(nums);
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int length = nums.length,maxSize=0,size=0,i=0;
        while(i<length) {
            size =0;
            while(i<length && nums[i] == 1) {
                size++;
                i++;
            }
            i++;
            maxSize = Math.max(maxSize,size);
        }
        return maxSize;
    }
}
