package com.madhu.psds.arrays;

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int sum = 0;
        int i;
        int j =0;
        int length = nums.length;
        int[] result = new int[length-2];
        for(i=0;i<k;i++) {
            sum += nums[i];
        }
        result[j] = sum;
        j++;
        for(i=k;i<length;i++) {
        }
        return result;
    }

    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k =3;
        maxSlidingWindow.maxSlidingWindow(nums,k);
    }
}
