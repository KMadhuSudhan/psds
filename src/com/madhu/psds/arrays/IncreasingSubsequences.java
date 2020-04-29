package com.madhu.psds.arrays;
//https://leetcode.com/problems/increasing-subsequences/
//491. Increasing Subsequences

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {
    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        IncreasingSubsequences increasingSubsequences = new IncreasingSubsequences();
        increasingSubsequences.findSubsequences(nums);
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> currentList = new ArrayList<>();
        Set<List<Integer>> listSet = new HashSet<>();
        dfs(nums,listSet,currentList,0);
        return new ArrayList<>(listSet);
    }

    void dfs(int[] nums,Set<List<Integer>> listSet,List<Integer> currentList,int start) {
        if(currentList.size() > 1) {
            listSet.add(new ArrayList<>(currentList));
        }
        for (int i=start;i<nums.length;i++) {
            if(currentList.size() == 0 || nums[i]>= currentList.get(currentList.size()-1)) {
                currentList.add(nums[i]);
                dfs(nums,listSet,currentList,i+1);
            }
        }
    }
}
