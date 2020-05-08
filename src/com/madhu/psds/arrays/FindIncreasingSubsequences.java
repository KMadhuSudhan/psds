package com.madhu.psds.arrays;
//https://leetcode.com/problems/increasing-subsequences/
//491. Increasing Subsequences

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindIncreasingSubsequences {
    public static void main(String[] args) {
        FindIncreasingSubsequences findIncreasingSubsequences = new FindIncreasingSubsequences();
        int[] nums = {4, 6, 7, 7};
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        Map<Integer,List<List<Integer>>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            List<List<Integer>> temp = new ArrayList<>();
            List<Integer> start = new ArrayList<>();
            start.add(nums[i]);
            temp.add(start);
            for (int j=0;j<i;j++) {
               if(nums[j]<=nums[i]) {
                   for (List<Integer> list : map.get(j)) {
                       list.add(nums[i]);
                       temp.add(list);
                   }
               }
            }
            map.put(i,temp);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer,List<List<Integer>>>  entry: map.entrySet()) {
            for (List<Integer> l : entry.getValue()) {
                if (l.size() > 1) result.add(l);
            }
        }
        return result;
    }
}
