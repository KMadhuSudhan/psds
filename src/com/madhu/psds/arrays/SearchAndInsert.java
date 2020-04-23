package com.madhu.psds.arrays;
//https://leetcode.com/problems/search-insert-position/submissions/
//35. Search Insert Position

public class SearchAndInsert {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        SearchAndInsert searchAndInsert = new SearchAndInsert();
        searchAndInsert.searchInsert(nums,5);
    }


    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int low = 0,high = length-1;
        while (low<=high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target) {
                low = mid+1;
            } else {
                high = mid -1;
            }
        }
        return low;
    }
}
