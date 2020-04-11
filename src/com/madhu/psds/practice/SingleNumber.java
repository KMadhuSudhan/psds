package com.madhu.psds.practice;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {2,2,1};
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(nums));
    }
    public int singleNumber(int[] nums) {
        int length = nums.length;
        int xor = 0;
        for(int i=0;i<length;i++) {
            xor^=nums[i];
        }
        return xor;
    }
}
