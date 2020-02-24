package com.madhu.psds.arrays;
//https://leetcode.com/problems/combination-sum/submissions/
//39. Combination Sum

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] nums = {2, 3, 6, 7};
        int sum = 7;
        combinationSum.combinationSum(nums, sum);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> sublist = new ArrayList<>();
        combinations(candidates, sublist, 0, result, candidates.length - 1, target);
        return result;
    }

    private void combinations(int[] candidates, ArrayList<Integer> list, int start, List<List<Integer>> result, int n, int sum) {
        if (sum < 0) return;
        if (sum == 0) {
            result.add((ArrayList) list.clone());
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(candidates[i]);
            combinations(candidates, list, i, result, n, sum - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}
