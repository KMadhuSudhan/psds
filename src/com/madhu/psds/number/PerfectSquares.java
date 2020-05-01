package com.madhu.psds.number;
//https://leetcode.com/problems/perfect-squares/
//279. Perfect Squares


import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {
    public static void main(String[] args) {
        int n = 12;
        PerfectSquares perfectSquares = new PerfectSquares();
        System.out.println(perfectSquares.numSquares(n));
    }

    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i*i <= n; i++) {
            squares.add(i * i);
        }
        int[][] dp = new int[squares.size()+1][n+1];
        for (int val=1;val<=n;++val)
            dp[0][val] = Integer.MAX_VALUE;

        for (int val=1;val<=n;++val)
        {
            for (int c=1;c<=squares.size();++c)
            {
                int take = Integer.MAX_VALUE;
                if (val >= squares.get(c-1)) take = dp[c][val-squares.get(c-1)] + 1;

                int dont = dp[c-1][val];
                dp[c][val] = Math.min(take,dont);
            }
        }

        return dp[squares.size()][n];
    }
}
