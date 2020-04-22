package com.madhu.psds.arrays;
//https://leetcode.com/problems/find-peak-element/
//162. Find Peak Element

public class FindPeak {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        FindPeak findPeak = new FindPeak();
        findPeak.findPeakElement(nums);
    }
    public int findPeakElement(int[] nums) {
        int length = nums.length;
        if(length <=1 ) return 0;
        int prev = nums[0];
        int index = 1;
        while (index < length) {
            if(nums[index] > prev) {
                prev = nums[index];
            } else {
                return index-1;
            }
            index++;
        }
        return index == length ? index-1 : index;
    }
}
