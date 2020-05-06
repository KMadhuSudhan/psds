package com.madhu.psds.arrays;
//https://leetcode.com/problems/majority-element-ii/
//229. Majority Element II

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MajarityElementII {
    public static void main(String[] args) {
        MajarityElementII majarityElementII = new MajarityElementII();
        int[] nums = {3,2,3};
        majarityElementII.majorityElement(nums);
    }
    public List<Integer> majorityElement(int[] nums) {
        Set<Integer> list = new HashSet<>();
        int x = getMajarity(nums,0,nums.length/3);
        int y = getMajarity(nums,nums.length/3,2*nums.length/3);
        int z = getMajarity(nums,2*nums.length/3,nums.length);

        if(isOneThirdMajority(nums,nums.length, x)) list.add(x);
        if(isOneThirdMajority(nums,nums.length, y)) list.add(y);
        if(isOneThirdMajority(nums,nums.length, z)) list.add(z);

        x = reverseGetMajarity(nums,0,nums.length/3);
        y = reverseGetMajarity(nums,nums.length/3,2*nums.length/3);
        z = reverseGetMajarity(nums,2*nums.length/3,nums.length);

        if(isOneThirdMajority(nums,nums.length, x)) list.add(x);
        if(isOneThirdMajority(nums,nums.length, y)) list.add(y);
        if(isOneThirdMajority(nums,nums.length, z)) list.add(z);
        return new ArrayList<>(list);
    }

    private boolean isOneThirdMajority(int[] nums, int N, int x){
        int count = 0;
        for(int i = 0; i < N; i++){
            if(nums[i] == x)
                ++count;
        }

        return (count > (N/3));
    }

    public int reverseGetMajarity(int[] nums,int start,int end) {
        int majarity = end-1,count = 1;
        for (int i=end-1;i>=start;i--) {
            if(nums[i] == nums[majarity]) {
                count++;
            } else {
                count--;
            }
            if(count==0) {
                majarity = i;
                count=1;
            }
        }
        return nums[majarity];
    }

    public int getMajarity(int[] nums,int start,int end) {
        int majarity = start,count = 1;
        for (int i=start;i<end;i++) {
            if(nums[i] == nums[majarity]) {
                count++;
            } else {
                count--;
            }
            if(count==0) {
                majarity = i;
                count=1;
            }
        }
        return nums[majarity];
    }
}
