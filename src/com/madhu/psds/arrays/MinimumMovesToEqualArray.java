package com.madhu.psds.arrays;
//https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
//453. Minimum Moves to Equal Array Elements

public class MinimumMovesToEqualArray {

    public static void main(String[] args) {
        MinimumMovesToEqualArray movesToEqualArray = new MinimumMovesToEqualArray();
        int[] nums = {1,2,3};
        movesToEqualArray.minMoves(nums);
    }
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            min = Math.min(num, min);
            sum += num;
        }
        return sum - min * nums.length;
    }
}
