package com.madhu.psds.arrays;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public static void main(String[] args) {
        SubSets subSets = new SubSets();
        int[] nums = {1,2,3};
        subSets.subsets(nums);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subResult = new ArrayList<>();
        int n = nums.length;
        allSubSets(nums,subResult,result,0,n);
        return result;
    }

    public void allSubSets(int[] nums,List<Integer> subResult,List<List<Integer>> result,int index,int n) {
        result.add(new ArrayList<>(subResult));
        for(int i=index;i<n;i++) {
            subResult.add(nums[i]);
            allSubSets(nums,subResult,result,i+1,n);
            subResult.remove(subResult.size() -1);
        }
    }
}
