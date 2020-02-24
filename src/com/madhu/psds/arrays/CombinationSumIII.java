package com.madhu.psds.arrays;
//https://leetcode.com/problems/combination-sum-iii/
//216. Combination Sum III

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combine(int k,int sum) {
        List<List<Integer>> result = new ArrayList<>();
        combinations(new ArrayList(), 1,result,9, k,sum);
        return result;
    }
    private void combinations(ArrayList<Integer> list, int start,List<List<Integer>> result ,int n,int k,int sum) {
        if(sum < 0) return;
        if(list.size() == k && sum != 0) {
            return;
        }
        if(list.size() == k && sum == 0) {
            result.add((ArrayList) list.clone());
        } else {
            for (int i=start;i<=n;i++) {
                list.add(i);
                combinations(list,i+1,result,n,k,sum - i);
                list.remove(list.size() -1);
            }
        }
    }

    public static void main(String[] args) {
        IntegerCombinations integerCombinations = new IntegerCombinations();
        int n=9;
        int k=3;
        integerCombinations.combine(n,k);
    }
}
