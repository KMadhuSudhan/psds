package com.madhu.psds.arrays;
//https://leetcode.com/problems/rotate-array/submissions/
//189. Rotate Array

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(nums, 3);
        rotateArray.print(nums);
    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        if(k == 0 || length == 0 ) return;
        k = length - k;
        reverse(nums, 0, k-1);
        reverse(nums, k, length-1);
        reverse(nums, 0, length-1);
    }

    public void reverse(int[] nums, int low, int high) {
       for(int i = low,j=high-1;i<j;i++,j--) {
           int temp = nums[i];
           nums[i] = nums[j];
           nums[j] = temp;
       }
    }

    public void print(int[] nums) {
        for (int num : nums) {
            System.out.print(" " + num);
        }
    }
}