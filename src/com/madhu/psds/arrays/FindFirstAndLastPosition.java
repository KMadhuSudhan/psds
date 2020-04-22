package com.madhu.psds.arrays;
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
//34. Find First and Last Position of Element in Sorted Array

public class FindFirstAndLastPosition {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        FindFirstAndLastPosition findFirstAndLastPosition = new FindFirstAndLastPosition();
         findFirstAndLastPosition.searchRange(nums,target);
    }
    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;

        if(length == 0) return new int[] {-1,-1};
        if(length == 1 && nums[0] == target) return new int[] {0,0};
        else if(length == 1)  return new int[] {-1,-1};

        int low = 0;
        int high = length -1;
        int elementIndex = -1;

        while (low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                elementIndex = mid;
                break;
            }
            else if(nums[mid] < target) {
                low = mid  + 1;
            } else {
                high = mid - 1;
            }
        }
        if(elementIndex == -1) {
            return new int[]{-1,-1};
        }
        int i = elementIndex;
        int j = elementIndex;
        while (i<length &&  nums[i] == target) i++;
        while (j>=0 &&  nums[j] == target) j--;
        return new int[] {j!=elementIndex ? j +1 : j,i!=elementIndex ? i -1 : i};
    }
}
