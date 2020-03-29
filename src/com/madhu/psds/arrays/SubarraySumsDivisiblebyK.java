package com.madhu.psds.arrays;
//974. Subarray Sums Divisible by K

//https://leetcode.com/problems/subarray-sums-divisible-by-k/
public class SubarraySumsDivisiblebyK {
    public static void main(String[] args) {
        SubarraySumsDivisiblebyK subarraySumsDivisiblebyK = new SubarraySumsDivisiblebyK();
        int[] nums = {4,5,0,-2,-3,1};
        subarraySumsDivisiblebyK.subarraysDivByK(nums,5);
    }
    public int subarraysDivByK(int[] A, int K) {
        int N = A.length;
        int[] P = new int[N+1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + A[i];

        int[] count = new int[K];
        for (int x: P)
            count[(x % K + K) % K]++;

        int ans = 0;
        for (int v: count)
            ans += v * (v - 1) / 2;
        return ans;
    }
}
/*

0    0 -> 1
sum 4 4->1
sum 9 9->1
sum 9 9->2
sum 7 7->1
sum 4 4->1
sum 5 5->1
 */