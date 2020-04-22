package com.madhu.psds.arrays;
//https://leetcode.com/problems/longest-consecutive-sequence/
//128. Longest Consecutive Sequence

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
//        int[] nums = {100, 4, 200, 1, 3, 2};
        int[] nums = {0,0};
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        System.out.println(longestConsecutiveSequence.longestConsecutive(nums));
    }
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet();
        int length = nums.length;
        if(length <= 1) return length;
        for (int i=0;i<length;i++) {
            set.add(nums[i]);
        }
        int size = 0;
        int maxSize = 0;
        for (int i=0;i<length;i++) {
            if(!set.contains(nums[i]-1)){
                int sequence = nums[i]  + 1;
                size = 1;
                while (set.contains(sequence)) {
                    size++;
                    sequence++;
                }
                maxSize = Math.max(size,maxSize);
                size = 0;
            }
        }
        maxSize = Math.max(size,maxSize);
        return maxSize;
    }
}
