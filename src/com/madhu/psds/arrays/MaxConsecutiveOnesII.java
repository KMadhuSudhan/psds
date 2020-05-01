package com.madhu.psds.arrays;
//https://leetcode.com/problems/max-consecutive-ones-iii/
//1004. Max Consecutive Ones III

public class MaxConsecutiveOnesII {
    public static void main(String[] args) {
        MaxConsecutiveOnesII maxConsecutiveOnesII = new MaxConsecutiveOnesII();
        int[] nums = {1,0,0,0,1,1,0,0,1,1,0,0,0,0,  0, 0,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1,0,1,0,0,1,1,0,1,1};
        System.out.println(maxConsecutiveOnesII.longestOnes(nums, 8));
    }

    public int longestOnes(int[] A, int K) {
        int length = A.length,zeros = 0, ones = 0,maxSize=0,low=0;
        if(length == K) return length;
        for(int high=0;high<length;high++) {
            if(A[high] == 0) {
                zeros++;
            }
            while (zeros > K) {
                if (A[low] == 0) {
                    zeros--;
                }
                low++;
            }
            maxSize = Math.max(maxSize,high-low + 1);
        }
        return maxSize;
    }
}
