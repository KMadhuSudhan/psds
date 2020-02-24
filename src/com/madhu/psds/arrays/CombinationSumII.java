package com.madhu.psds.arrays;
//https://leetcode.com/problems/combination-sum-ii/
//40. Combination Sum II

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        CombinationSumII combinationSum = new CombinationSumII();
        int[] nums = {2, 3, 6, 7};
        int sum = 7;
        combinationSum.combinationSum(nums, sum);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> sublist = new ArrayList<>();
        Arrays.sort(candidates);
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
            if( i!= start && candidates[i] == candidates[i-1]){
                continue;
            }
            if(candidates[i] > sum){
                break;
            }
            list.add(candidates[i]);
            combinations(candidates, list, i + 1, result, n, sum - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}
