package com.madhu.psds.arrays;
//https://leetcode.com/problems/combinations/

import java.util.ArrayList;
import java.util.List;

public class IntegerCombinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combinations(new ArrayList(), 1,result,n, k);
        return result;
    }
    private void combinations(ArrayList<Integer> list, int start,List<List<Integer>> result ,int n,int k) {
        if(list.size() == k) {
            result.add((ArrayList) list.clone());
        } else {
            for (int i=start;i<=n;i++) {
                list.add(i);
                combinations(list,i+1,result,n,k);
                list.remove(list.size() -1);
            }
        }
    }

    public static void main(String[] args) {
        IntegerCombinations integerCombinations = new IntegerCombinations();
        int n=4;
        int k=2;
        integerCombinations.combine(n,k);
    }
}
