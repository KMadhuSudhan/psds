package com.madhu.psds.arrays;
//https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/
//1186. Maximum Subarray Sum with One Deletion

public class MaximumSubarraySumwithOneDeletion {
    public static void main(String[] args) {
        MaximumSubarraySumwithOneDeletion maximumSubarraySumwithOneDeletion = new MaximumSubarraySumwithOneDeletion();
        int[] nums = {1,-2,0,3};
        maximumSubarraySumwithOneDeletion.maximumSum(nums);
    }
    public int maximumSum(int[] arr) {
        int ans=arr[0];
        int max_sum_without_deletion=arr[0];
        int max_sum_with_deletion=0;
        for(int i=1;i<arr.length;i++){
            max_sum_with_deletion= Math.max(max_sum_with_deletion+arr[i],max_sum_without_deletion); //chossing max_sum_without_deletion means that we are deletion the ith element
            max_sum_without_deletion=Math.max(max_sum_without_deletion+arr[i],arr[i]);
            ans=Math.max(Math.max(max_sum_with_deletion,max_sum_without_deletion),ans);
        }
        return ans;
    }
}
