package com.madhu.psds.arrays;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,0,1,1,1};
        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        maxConsecutiveOnes.findMaxConsecutiveOnes(nums);
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int length = nums.length;
        if(nums[0] == 1 && length == 1) return 1;
        int maxCount = nums[0] == 1 ? 1: 0;
        int count = nums[0] == 1 ? 1: 0;
        for(int i=1;i<length;i++ ) {
            if(nums[i] == 1) {
                count++;
                maxCount = Math.max(maxCount,count);
            } else {
                count=0;
            }
        }
        return maxCount;
    }
}
