package com.madhu.psds.arrays;
//https://leetcode.com/problems/jump-game-ii/submissions/
//45. Jump Game II

public class JumpGameII {
    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
        int[] nums = {2,3,1,1,4};
        jumpGameII.jump(nums);
    }
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int count = 0;
        int i = 0;
        while (i + nums[i] < nums.length - 1) {
            int maxVal = 0;
            int maxValIndex = 0;
            for (int j = 1; j <= nums[i]; j++) {
                if (nums[j + i] + j > maxVal) {
                    maxVal = nums[j + i] + j;
                    maxValIndex = i + j;
                }
            }
            i = maxValIndex;
            count++;
        }
        return count + 1;
    }
}
