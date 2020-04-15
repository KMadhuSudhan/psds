package com.madhu.psds.arrays;
//https://leetcode.com/problems/find-all-duplicates-in-an-array/
//442. Find All Duplicates in an Array

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {
    public static void main(String[] args) {
        int[] nums = {10,2,5,10,9,1,1,4,3,7};
        FindAllDuplicates findAllDuplicates = new FindAllDuplicates();
        System.out.println(findAllDuplicates.findDuplicates(nums));
    }
    public List<Integer> findDuplicates(int[] nums) {
        int length = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<length;i++) {
            if(nums[Math.abs(nums[i])-1] < 0) {
                list.add(-nums[Math.abs(nums[i]) - 1]);
            } else {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }
        return list;
    }
}
