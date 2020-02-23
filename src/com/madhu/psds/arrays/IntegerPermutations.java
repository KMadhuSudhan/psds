package com.madhu.psds.arrays;
//https://leetcode.com/problems/permutations/submissions/
//46. Permutations

import java.util.ArrayList;
import java.util.List;

public class IntegerPermutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        permutations(nums, 0, result, length);
        return result;
    }

    public void permutations(int[] nums, int start, List<List<Integer>> result, int n) {
        if (start == n) {
            result.add(convertArrayToList(nums.clone(), n));
        } else {
            for (int i = start; i < n; i++) {
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

    public static void main(String[] args) {
        IntegerPermutations integerPermutations = new IntegerPermutations();
        int[] nums = {1,2,3};
        integerPermutations.permute(nums);
    }
}
