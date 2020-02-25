package com.madhu.psds.arrays;
//https://leetcode.com/problems/4sum/
//18. 4Sum

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        FourSum fourSum = new FourSum();
        fourSum.fourSum(nums,0);
    }

    public List<List<Integer>> fourSum(int[] nums,int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                for (int j = i + 1; j < n - 2; j++) {
                    if (j == i+1 || (j > i+1 && nums[j] != nums[j - 1])) {
                        int left = j + 1;
                        int right = n - 1;
                        while (left < right) {
                            int sum = nums[i] + nums[j] + nums[left] + nums[right];
                            if (sum > target) right--;
                            else if (sum < target) left++;
                            else {
                                List<Integer> list = new ArrayList<>();
                                list.add(nums[j]);
                                list.add(nums[left]);
                                list.add(nums[right]);
                                result.add(list);
                                while (left < right && nums[right] == nums[right - 1]) right--;
                                while (left < right && nums[left] == nums[left + 1]) left++;
                                left++;
                                right--;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
