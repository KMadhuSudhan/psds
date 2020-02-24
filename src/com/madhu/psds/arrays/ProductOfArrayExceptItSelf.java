package com.madhu.psds.arrays;

public class ProductOfArrayExceptItSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        ProductOfArrayExceptItSelf productOfArrayExceptItSelf = new ProductOfArrayExceptItSelf();
    }

    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int length = nums.length;
        int[] ans = new int[length];
        for(int i=0;i<length;i++) {
            product*=nums[i];
        }
        for(int i=0;i<length;i++) {
            if(nums[i] == 0) {
                ans[i] = 0;
            } else {
                ans[i] = product / nums[i];
            }
        }
        return ans;
    }
}
