package com.madhu.psds.arrays;
//https://leetcode.com/problems/jump-game/
//55. Jump Game

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        JumpGame jumpGame = new JumpGame();
        jumpGame.canJump(nums);
    }

    public boolean canJump(int[] nums) {
        int maxJump = nums[0];
        for (int i=0;i<nums.length-1;i++) {
            if(maxJump >= nums.length - i || maxJump>= nums.length -1) return true;
            if(nums[i] == 0 && maxJump < 1) return false;
            if(maxJump -1 >= nums[i+1]) {
                maxJump = maxJump - 1;
            } else {
                maxJump = nums[i+1];
            }
        }
        return true;
    }

//    public boolean canJump(int[] nums) {
//        int length = nums.length;
//        int currentPoint = length-1;
//        boolean flag = true;
//        for(int i=length-2;i>=0;i--) {
//            if((i+nums[i]) >= currentPoint) {
//                currentPoint = i;
//                flag = true;
//            } else {
//                flag = false;
//            }
//        }
//        return flag;
//    }
}
