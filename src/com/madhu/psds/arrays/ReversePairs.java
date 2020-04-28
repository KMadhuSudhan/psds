package com.madhu.psds.arrays;

import java.util.Stack;

public class ReversePairs {
    public static void main(String[] args) {
        int[] nums = {1,3,2,3,1};
        ReversePairs reversePairs = new ReversePairs();
        reversePairs.reversePairs(nums);
    }

    public int reversePairs(int[] nums) {
        return mergeSortAndCount(nums,0,nums.length);
    }

    public int mergeSortAndCount(int[] nums,int start,int end) {
        if(start<end) {
            int mid = start + (end-start)/2 ;
            int count = mergeSortAndCount(nums,start,mid) + mergeSortAndCount(nums,mid+1,end);
            int j=mid+1;
            for (int i=start;i<=mid;i++) {
                while (j<=end && (long) nums[i] > (long) 2*nums[j]) {
                    count++;
                    j++;
                }
            }
            return count;
        } else {
            return 0;
        }
    }
}
