package com.madhu.psds.arrays;
//https://leetcode.com/problems/next-permutation/
//31. Next Permutation

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int j = n-1;
        while(j > 0 && nums[j-1] >= nums[j])
            j--;
        if(j == 0){
            Arrays.sort(nums);
            return;
        }
        j = j-1;
        int k = n-1;
        while(k > j && nums[k] <= nums[j])
            k--;
        int temp = nums[j];
        nums[j] = nums[k];
        nums[k] = temp;
        j = j+1;
        k = n-1;
        while(j < k){
            int copy = nums[j];
            nums[j++] = nums[k];
            nums[k--] = copy;
        }
    }
}
