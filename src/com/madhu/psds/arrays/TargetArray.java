package com.madhu.psds.arrays;
//https://leetcode.com/problems/create-target-array-in-the-given-order/
//1389. Create Target Array in the Given Order

import java.util.ArrayList;
import java.util.List;

public class TargetArray {
    public static void main(String[] args) {
        int[]  nums = {0,1,2,3,4};
        int[] index = {0,1,2,2,1};
        TargetArray targetArray = new TargetArray();
        targetArray.createTargetArray(nums,index);
        targetArray.print(nums);
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        int length = nums.length;
        int[] result = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<length;i++) {
            list.add(index[i],nums[i]);
        }
        int i=0;
        for (int num: list) {
            result[i++] = num;
        }
        return result;
    }
    private void print(int[] nums) {
        for (int num: nums) {
            System.out.print(num + " ");
        }
    }
}
