package com.madhu.psds.arrays;
//https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
//462. Minimum Moves to Equal Array Elements II

import java.util.Arrays;

public class MinimumMovesToEqualArrayII {
    public static void main(String[] args) {
        MinimumMovesToEqualArrayII minimumMovesToEqualArrayII = new MinimumMovesToEqualArrayII();
        int[] nums = {1,2,3};
        minimumMovesToEqualArrayII.minMoves2(nums);
    }

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length/2];
        int moves=0;

        for(int i=0; i<nums.length;i++){
            moves+= Math.abs(nums[i]-median);
        }
        return moves;
    }
}
