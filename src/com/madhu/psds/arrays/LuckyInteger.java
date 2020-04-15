package com.madhu.psds.arrays;
//https://leetcode.com/problems/find-lucky-integer-in-an-array/submissions/
//1394. Find Lucky Integer in an Array

import java.util.HashMap;
import java.util.Map;

public class LuckyInteger {
    public static void main(String[] args) {
        int[] nums = {
                2,2,3,4
        };
        LuckyInteger luckyInteger = new LuckyInteger();
        luckyInteger.findLucky(nums);
    }
    public int findLucky(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num: arr) {
            int count = map.getOrDefault(num,0);
            map.put(num,count+1);
        }
        int largest = -1;
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if(entry.getKey() == entry.getValue()) {
                largest = Math.max(largest,entry.getKey());
            }
        }
        return largest;
    }
}
