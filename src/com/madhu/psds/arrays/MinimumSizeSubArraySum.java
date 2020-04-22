package com.madhu.psds.arrays;
//https://leetcode.com/problems/minimum-size-subarray-sum/
//209. Minimum Size Subarray Sum

public class MinimumSizeSubArraySum {
    public static void main(String[] args) {
        MinimumSizeSubArraySum minimumSizeSubArraySum = new MinimumSizeSubArraySum();
        System.out.println(minimumSizeSubArraySum.minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0] >= s ? 1 : 0;
        int lo = 0, hi = 0, sum = 0, ml = nums.length + 1;
        while (hi < nums.length){
            sum += nums[hi];
            while (sum >= s){
                ml = Math.min(ml, hi - lo + 1);
                sum -= nums[lo];
                lo ++;
            }
            hi ++;
        }
        return ml > nums.length ? 0 : ml;
    }
}
