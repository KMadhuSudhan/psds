package com.madhu.psds.arrays;
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
//153. Find Minimum in Rotated Sorted Array

public class FindMinimumRotatedSortedArray {
    public static void main(String[] args) {
       int[] nums = {3,4,5,1,2};
        FindMinimumRotatedSortedArray findMinimumRotatedSortedArray = new FindMinimumRotatedSortedArray();
        findMinimumRotatedSortedArray.findMin(nums);
    }
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(mid+1<nums.length && nums[mid]>nums[mid+1])
                return nums[mid+1];
            else if(mid-1>=0 && nums[mid]<nums[mid-1])
                return nums[mid];
            else if(nums[mid]>nums[low])
                low = mid+1;
            else
                high = mid-1;
        }
        return nums[0];
    }
}
