package com.madhu.psds.arrays;
//https://leetcode.com/problems/3sum-closest/
//16. 3Sum Closest

import java.util.*;

public class ThreeSumClosest {
    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] nums = new int[]{-1, 2, 1, -4};
    }
    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for(int i=0;i<length-2;i++) {
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i+1;
            int right = length-1;
            while(left < right) {
                int current =  nums[i] + nums[left] + nums[right];
                if(current == target) return current;
                if(Math.abs(current - target) < Math.abs(result - target)) {
                    result =  current;
                }
                if(current < right) {
                    right--;
                } else {
                    left++;
                }
                while(left < right && nums[left]!=nums[left+1]) left++;
                while(left < right && nums[right]!=nums[right-1]) right--;
            }
        }
        return result;
    }
}
