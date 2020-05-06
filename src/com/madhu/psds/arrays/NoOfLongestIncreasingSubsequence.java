package com.madhu.psds.arrays;
//https://leetcode.com/problems/number-of-longest-increasing-subsequence/

public class NoOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        NoOfLongestIncreasingSubsequence noOfLongestIncreasingSubsequence = new NoOfLongestIncreasingSubsequence();
        noOfLongestIncreasingSubsequence.findNumberOfLIS(nums);
    }
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] cnt = new int[nums.length];
        int max = 0;
        for(int i=0;i<nums.length;i++) {
            dp[i] = 1;
            cnt[i] = 1;
        }
        for(int i=0;i<nums.length;i++) {
            for(int j=0;j<i;j++) {
                if(nums[i]>nums[j]) {
                    if(dp[j]+1 > dp[i]) {
                        dp[i] = Math.max(dp[i], 1 + dp[j]);
                        max = Math.max(max, dp[i]);
                    } else if(dp[i] == dp[j]) {
                        cnt[i]+=cnt[j];
                    }
                }
            }
        }
        int ans = 0;
        for (int i=0;i<nums.length;i++) {
            if(dp[i] == max) {
                ans+=cnt[i];
            }
        }
        return ans;
    }
}
