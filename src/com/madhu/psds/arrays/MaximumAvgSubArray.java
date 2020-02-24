package com.madhu.psds.arrays;
//https://leetcode.com/problems/maximum-average-subarray-i/
//643. Maximum Average Subarray I

public class MaximumAvgSubArray {
    public static void main(String[] args) {
        MaximumAvgSubArray maximumAvgSubArray = new MaximumAvgSubArray();
        int[] nums = {1,12,-5,-6,50,3};
        System.out.println(maximumAvgSubArray.findMaxAverage(nums,4));
    }

    public double findMaxAverage(int[] nums, int k) {
        int length = nums.length;
        double maxAvg,maxSoFarAvg,sum=0.0;
        int i;
        for(i=0;i<k;i++) {
            sum += nums[i];
        }
        maxAvg = ((double)sum)/((double) k);
        maxSoFarAvg = maxAvg;
        for (i=k;i<length;i++) {
            sum = k * maxAvg - nums[i-k] + nums [i];
            maxAvg =  ((double)sum)/((double) k);
            if(maxSoFarAvg < maxAvg) {
                maxSoFarAvg = maxAvg;
            }
        }
        return maxSoFarAvg;
    }
}
