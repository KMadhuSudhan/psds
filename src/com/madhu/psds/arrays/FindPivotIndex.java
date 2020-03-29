package com.madhu.psds.arrays;
//https://leetcode.com/problems/find-pivot-index/
//724. Find Pivot Index

public class FindPivotIndex {
    public static void main(String[] args) {
        //int[] nums = {1, 7, 3, 6, 5, 6};
        int[] nums = {-1,-1,-1,0,1,1};
        FindPivotIndex findPivotIndex = new FindPivotIndex();
        System.out.println(findPivotIndex.pivotIndex(nums));
    }

    public int pivotIndex(int[] nums) {
        int sum = 0;
        int length = nums.length;
        if(length == 0) return -1;
        for (int num: nums) sum+=num;
        int left = nums[0];
        if((sum  - left) == 0) return 0;
        for (int i=1;i<length;i++) {
            int right = sum - left - nums[i];
            if(right == left) return i;
            left += nums[i];
        }
        return -1;
    }
}
