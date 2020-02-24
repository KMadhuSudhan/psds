package com.madhu.psds.arrays;
//https://leetcode.com/problems/permutations-ii/
//47. Permutations II

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntegerPermutationsII {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        permutations(nums, 0,result, length);
        return result;
    }

    public void permutations(int[] nums, int start, List<List<Integer>> result, int n) {
        if (start == n) {
            result.add(convertArrayToList(nums.clone(), n));
        } else {
            HashMap<Integer,Boolean> map = new HashMap<>();
            for (int i = start; i < n; i++) {
                if (map.get(nums[i])) continue;
                map.put(nums[i],true);
                swap(nums,start,i);
                permutations(nums,start + 1,result,n);
                swap(nums,start,i);
            }
        }
    }

    public List<Integer> convertArrayToList(int[] input, int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(input[i]);
        }
        return result;
    }


    public void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
