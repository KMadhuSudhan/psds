package com.madhu.psds.arrays;
//https://leetcode.com/problems/coin-change-2/
//518. Coin Change 2

public class CoinChangeII {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        CoinChangeII coinChangeII = new CoinChangeII();
        System.out.println(coinChangeII.change(amount,coins));
    }
    public int change(int amount, int[] coins) {
//        int[][] dp = new int[coins.length+1][amount+1];
//        for (int i=0;i<=coins.length;i++) {
//            dp[i][0] = 1;
//        }
//        for(int i=1;i<=coins.length;i++) {
//            for(int j=1;j<=amount;j++) {
//                if(coins[i-1] > j) {
//                    dp[i][j] += dp[i-1][j];
//                } else {
//                    dp[i][j]+= dp[i-1][j] + dp[i][j - coins[i-1]];
//                }
//            }
//        }
//        return dp[coins.length][amount];

        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i=0;i<coins.length;i++) {
            for(int j=coins[i];j<=amount;j++) {
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
