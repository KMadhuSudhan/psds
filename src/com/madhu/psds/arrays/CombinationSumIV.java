package com.madhu.psds.arrays;
//https://leetcode.com/problems/combination-sum-iv/
//377. Combination Sum IV

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIV {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        CombinationSumIV combinationSumIV = new CombinationSumIV();
        combinationSumIV.combine(nums,4);
    }
    public List<List<Integer>> combine(int[] nums, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        combinations(nums,0,sum,nums.length-1,new ArrayList(),result);
        return result;
    }
    private void combinations(int[] nums,int start,int sum,int n,ArrayList<Integer> list,List<List<Integer>> result) {
        if(sum < 0) return;
        if(sum == 0) {
            result.add((ArrayList) list.clone());
        } else {
            for (int i=start;i<=n;i++) {
                list.add(nums[i]);
                combinations(nums,i,sum - nums[i],n,list,result);
                list.remove(list.size() -1);
            }
        }
    }
}
