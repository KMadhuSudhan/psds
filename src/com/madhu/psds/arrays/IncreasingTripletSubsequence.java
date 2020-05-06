package com.madhu.psds.arrays;
//https://leetcode.com/problems/increasing-triplet-subsequence/
//334. Increasing Triplet Subsequence

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        int[] nums = {2,1,5,0,4,6};
        IncreasingTripletSubsequence increasingTripletSubsequence = new IncreasingTripletSubsequence();
        System.out.println(increasingTripletSubsequence.increasingTriplet(nums));
    }
    public boolean increasingTriplet(int[] nums) {
       int min = nums[0],mid = Integer.MAX_VALUE;
       for (int i=1;i<nums.length;i++) {
           if(nums[i] > mid) {
               return true;
           }
           if(nums[i]<= min) {
               min = nums[i];
           } else {
               mid = Math.min(mid,nums[i]);
           }
       }
       return false;
    }
}
