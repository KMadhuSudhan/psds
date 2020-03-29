package com.madhu.psds.arrays;
//https://leetcode.com/problems/maximum-product-subarray/
//152. Maximum Product Subarray

public class MaximumProductArray {
    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        MaximumProductArray maximumProductArray = new MaximumProductArray();
        maximumProductArray.maxProduct(arr);
    }

    public int maxProduct(int[] nums) {
        int res = nums[0], firstNeg = 1;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (i == 0 || nums[i-1] == 0) ? nums[i] : nums[i] * nums[i-1];
            res = Math.max(res, nums[i]);
            if (nums[i] != 0) {
                if (nums[i] < 0) {
                    if (firstNeg > 0) firstNeg = nums[i];
                    else res = Math.max(res, nums[i]/firstNeg);
                }
            }
            else firstNeg = 1;
        }
        return res;
    }
}
