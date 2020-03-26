package com.madhu.psds.arrays;

public class SeggregationOfOddAndEven {
    public static void main(String[] args) {
        SeggregationOfOddAndEven seggregationOfOddAndEven = new SeggregationOfOddAndEven();
        int[] nums = {1,3,2,4,7,5,6,8,9};
        seggregationOfOddAndEven.segregate(nums);
        seggregationOfOddAndEven.print(nums);
    }

    private void segregate(int[] nums) {
        int length = nums.length;
        int start = 0;
        int end = length-1;
        while (start<end) {
            while (start < length && nums[start]%2 == 1 ) start++;
            while (end>=0 && nums[end]%2 == 0) end--;
            if(start!=end && start!=length && end>=0) swap(nums,start,end);
        }
    }

    private void swap(int[] nums,int start,int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    private void print(int[] nums) {
        for (int i=0;i<nums.length;i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
