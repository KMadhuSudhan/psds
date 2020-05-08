package com.madhu.psds.arrays;
//https://leetcode.com/problems/min-cost-climbing-stairs/

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int prev = 0;
        int curr = 0;
        int next = 0;

        for (int i = 0; i < cost.length; i++) {
            next = Math.min(prev, curr) + cost[i];
            prev = curr;
            curr = next;
        }

        return Math.min(curr, prev);
    }
}
