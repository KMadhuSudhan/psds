package com.madhu.psds.arrays;
//https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/submissions/
//1282. Group the People Given the Group Size They Belong To

import java.util.*;

public class GroupSizeTheyBelong {
    public static void main(String[] args) {
        GroupSizeTheyBelong groupSizeTheyBelong = new GroupSizeTheyBelong();
        int[] nums = {3, 3, 3, 3, 3, 1, 3};
        groupSizeTheyBelong.groupThePeople(nums);
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer,List<Integer>> listMap = new HashMap<>();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i=0;i<groupSizes.length;i++) {
            if(listMap.containsKey(groupSizes[i])) {
                List<Integer> temp = listMap.get(groupSizes[i]);
                temp.add(i);
                if(temp.size() == groupSizes[i]) {
                    lists.add(temp);
                    listMap.remove(groupSizes[i]);
                }
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                if(1==groupSizes[i])
                    lists.add(temp);
                else
                    listMap.put(groupSizes[i],temp);
            }
        }
        Set<Integer> keys= listMap.keySet();
        for(int i:keys)
            lists.add(listMap.get(i));
        return lists;
    }
}
