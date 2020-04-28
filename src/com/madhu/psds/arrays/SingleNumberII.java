package com.madhu.psds.arrays;
//https://leetcode.com/problems/single-number-ii/
//137. Single Number II

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        //[2,2,3,2]
        // 2 --> 0010
        // 3 --> 0011


        int ans = 0;

        for (int i = 0; i < 32; i++) {
            int countSetbit = 0;
            for (int a : nums) {
                if ((a & (1 << i)) != 0) {
                    countSetbit++;
                }
            }

            if (countSetbit % 3 != 0) {
                ans = ans | (1 << i);
            }
        }
        return ans;
    }
}
