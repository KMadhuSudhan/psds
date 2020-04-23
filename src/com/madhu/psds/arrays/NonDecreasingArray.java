package com.madhu.psds.arrays;
//https://leetcode.com/problems/non-decreasing-array/submissions/
//665. Non-decreasing Array

public class NonDecreasingArray {
    public static void main(String[] args) {
        int[] nums = {1,5,4,6,7,10,8,9};
        NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();
        System.out.println(nonDecreasingArray.checkPossibility(nums));
    }

    public boolean checkPossibility(int[] nums) {
        int count=0;
        for(int i=1;i<nums.length;i++) {
            if(nums[i]<nums[i-1]) {
                boolean checkLeft=false;
                boolean checkRight=false;
                if(i==nums.length-1||nums[i-1]<=nums[i+1])
                    checkRight=true;
                if(i==1||nums[i-2]<=nums[i])
                    checkLeft=true;
                if((checkLeft==false&&checkRight==false) || count>1)
                    return false;
                count++;
            }
        }
        return count<=1;
    }
}
