package com.madhu.psds.arrays;

public class MaximumProductArray {
    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        MaximumProductArray maximumProductArray = new MaximumProductArray();
        maximumProductArray.maxProduct(arr);
    }

    public int maxProduct(int[] nums) {
        int max = 1;
        int length = nums.length;
        int maxSoFar = 0;
        for (int i =0;i<length;i++) {
            max = max * nums[i];
            if(maxSoFar < max) {
                maxSoFar = max;
            }
            if(max < 0) {
                max = 1;
            }
        }
        return maxSoFar;
    }
}
