package com.madhu.psds.arrays;
//https://leetcode.com/problems/largest-number-at-least-twice-of-others/
//747. Largest Number At Least Twice of Others

public class LargestNumberAtLeastTwiceOfOthers {
    public static void main(String[] args) {
        LargestNumberAtLeastTwiceOfOthers largestNumberAtLeastTwiceOfOthers = new LargestNumberAtLeastTwiceOfOthers();
        int[] nums = {3, 6, 1, 0};
        System.out.println(largestNumberAtLeastTwiceOfOthers.dominantIndex(nums));
    }
    public int dominantIndex(int[] nums) {
        int length = nums.length;
        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i=0;i<length;i++) {
            if(max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        for(int i=0;i<length;i++) {
            if(nums[i]*2 <= max || nums[i] == max) continue;
            return -1;
        }
        return index;
    }
}
