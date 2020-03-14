package com.madhu.psds.arrays;
//https://leetcode.com/problems/single-element-in-a-sorted-array/
//540. Single Element in a Sorted Array

public class SingleElementInASortedArray {
    public static void main(String[] args) {
        SingleElementInASortedArray singleElementInASortedArray = new SingleElementInASortedArray();
        int[] nums = {1,1,2,3,3,4,4,8,8};
        singleElementInASortedArray.singleNonDuplicate(nums);
    }
    public int singleNonDuplicate(int[] nums) {
        int x = nums[0];
        for(int i=1;i<nums.length;i++) {
            x^=nums[i];
        }
        return x;
    }
}
