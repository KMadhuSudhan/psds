package com.madhu.psds.arrays;
//https://leetcode.com/problems/best-sightseeing-pair/submissions/
//1014. Best Sightseeing Pair

public class BestSightSeeingPair {
    public static void main(String[] args) {
        int[] nums = {8,1,5,2,6};
        BestSightSeeingPair bestSightSeeingPair = new BestSightSeeingPair();
        System.out.println(bestSightSeeingPair.maxScoreSightseeingPair(nums));
    }
    public int maxScoreSightseeingPair(int[] A) {
        int store[] = new int[A.length];
        int max = 0;
        for(int i=0;i<A.length-1;i++)
        {
            max = Math.max(max , A[i] + i);
            store[i] = max;
        }
        int res = Integer.MIN_VALUE;
        for(int i=A.length -1 ;i>=1;i--)
        {
            res = Math.max (res , A[i] - i + store[i-1]);
        }

        return res;
    }
}
