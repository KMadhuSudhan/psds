package com.madhu.psds.arrays;
//https://leetcode.com/problems/single-number-iii/
//260. Single Number III


public class SingleNumberIII {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        SingleNumberIII singleNumberIII = new SingleNumberIII();
        singleNumberIII.singleNumber(nums);
    }
    public int[] singleNumber(int[] nums) {
        int res = 0, nums1 = 0, nums2 = 0, firstOne = 0;

        for(int n:nums) res ^= n;

        firstOne  = ((res)&(res-1)) ^ res;

        for(int n:nums){
            if((n & firstOne) == 0 ){
                nums2 ^=n;
            }else{
                nums1 ^=n;
            }
        }
        return  new int[]{nums1,nums2};
    }
}
