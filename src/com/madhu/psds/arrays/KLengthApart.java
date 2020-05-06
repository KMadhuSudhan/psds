package com.madhu.psds.arrays;
//https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
//1437. Check If All 1's Are at Least Length K Places Away

public class KLengthApart {
    public static void main(String[] args) {
        KLengthApart kLengthApart = new KLengthApart();
        int[] nums = {1,0,0,0,1,0,0,1};
        System.out.println(kLengthApart.kLengthApart(nums,2));
    }
    public boolean kLengthApart(int[] nums, int k) {
        int prevIndex,i=0;
        while (i<nums.length && nums[i] != 1) {
            i++;
        }
        prevIndex = i;
        i++;
        while (i<nums.length) {
            if(nums[i] ==1) {
                if((i-prevIndex - 1) >= k) {
                    prevIndex = i;
                    i++;
                } else {
                    return false;
                }
            } else {
                i++;
            }
        }
        return true;
    }
}
