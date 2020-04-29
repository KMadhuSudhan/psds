package com.madhu.psds.arrays;
//https://leetcode.com/problems/maximum-length-of-repeated-subarray/
//718. Maximum Length of Repeated Subarray

public class MaximumLengthofRepeatedSubarray {
    public static void main(String[] args) {
        int[] a = {0,0,0,0,0,0,1,0,0,0};
        int[] b = {0,0,0,0,0,0,0,1,0,0};
        MaximumLengthofRepeatedSubarray maximumLengthofRepeatedSubarray = new MaximumLengthofRepeatedSubarray();
        System.out.println(maximumLengthofRepeatedSubarray.findLength(a,b));
    }
    public int findLength(int[] A, int[] B) {
        int ans = 0;

        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    ans = Math.max(ans, dp[i + 1][j + 1]);
                }
            }
        }

        return ans;
    }
}
