package com.madhu.psds.arrays;
//https://leetcode.com/problems/continuous-subarray-sum/
//523. Continuous Subarray Sum

import java.util.HashSet;
import java.util.Set;

public class ContinuousSubarray {
    public static void main(String[] args) {
        int[] nums = {23, 2, 4, 6, 7};
        ContinuousSubarray continuousSubarray = new ContinuousSubarray();
        continuousSubarray.checkSubarraySum(nums,6);
    }
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2) {
            return false;
        }

        if(k==0) {
            for(int i=1; i<nums.length; i++) {
                //the only possibility to have a 0 sequence is having two zeroes in a row
                if (nums[i] + nums[i-1] == 0) {
                    return true;
                }
            }
        } else {
            Set<Integer> remainders = new HashSet<>();
            int remainder = 0;
            int previousReminder = 0;
            for(int i=0; i<nums.length; i++) {
                //summing up the remainder from the previous summed numbers + current number
                remainder = (remainder + nums[i]) % k;
                //if a remainder appears twice on the set this means that removing it from the last sum
                // would result on a multiple from wanted number
                if(remainders.contains(remainder)){
                    return true;
                }
                //first time initialize it with 0 because we are not actually checking the first two numbers.
                remainders.add(previousReminder);
                previousReminder = remainder;
            }

        }
        return false;
    }
}
