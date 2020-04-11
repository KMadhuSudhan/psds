package com.madhu.psds.practice;

public class MaxSubArray {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int max = 0;
        int maxSoFar = 0;
        int start = -1;
        int end = -1;
        for(int i=0;i<length;i++) {
            max += nums[i];
            if(maxSoFar < max) {
                maxSoFar = max;
            }
            if(max < 0) {
                max = 0;
            }
        }
        return maxSoFar;
    }
}
