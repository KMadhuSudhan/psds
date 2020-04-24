package com.madhu.psds.matrix;
//https://leetcode.com/problems/count-square-submatrices-with-all-ones
//1277. Count Square Submatrices with All Ones

public class CountSquareSubmatrices {

    public static void main(String[] args) {
        CountSquareSubmatrices countSquareSubmatrices = new CountSquareSubmatrices();
        int[][] matrix = {
                {0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}
        };
        countSquareSubmatrices.countSquares(matrix);
    }
    public int countSquares(int[][] matrix) {
        int ans = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                dp[i][j] = matrix[i][j];
                if(i > 0 && j > 0 && dp[i][j] > 0) {
                    int min = Math.min(dp[i-1][j-1],dp[i-1][j]);
                    min = Math.min(min,dp[i][j-1]);
                    dp[i][j] += min;
                }
                ans+=dp[i][j];
            }
        }
        return ans;
    }
}
