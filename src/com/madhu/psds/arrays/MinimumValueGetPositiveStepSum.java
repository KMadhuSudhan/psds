package com.madhu.psds.arrays;
//https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
//1413. Minimum Value to Get Positive Step by Step Sum

public class MinimumValueGetPositiveStepSum {
    public int minStartValue(int[] nums) {
        int start = 0, minStart = 0;
        for(int n : nums) {
            start += n;
            minStart = Math.min( minStart, start);
        }
        return  minStart< 0 ? -minStart+1 : minStart+1;
    }
}
