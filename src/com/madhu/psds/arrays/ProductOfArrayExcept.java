package com.madhu.psds.arrays;
//https://leetcode.com/problems/product-of-array-except-self/submissions/
//238. Product of Array Except Self

public class ProductOfArrayExcept {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        ProductOfArrayExcept productOfArrayExcept = new ProductOfArrayExcept();
        productOfArrayExcept.productExceptSelf(nums);
    }
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        ans[0] = nums[0];
        for(int i=1;i<length;i++) {
            ans[i] = ans[i-1] * nums[i];
        }
        int rightProduct = nums[length-1];
        for (int i= length-2;i>0;i--) {
            ans[i] = rightProduct * ans[i-1];
            rightProduct = rightProduct * nums[i];
        }
        ans[0] = rightProduct;
        return ans;
    }
}
