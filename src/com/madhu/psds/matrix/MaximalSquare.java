package com.madhu.psds.matrix;
//https://leetcode.com/problems/maximal-square/
//221. Maximal Square

public class MaximalSquare {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        MaximalSquare maximalSquare = new MaximalSquare();
        maximalSquare.maximalSquare(matrix);
    }

    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int rows = matrix.length,cols = matrix[0].length;
        int[][] grid = new int[rows+1][cols+1];
        int maxLength = 0;
        for (int i=1;i<=rows;i++) {
            for (int j=1;j<=cols;j++) {
                if(matrix[i-1][j-1] == '1') {
                    int min = Math.min(grid[i-1][j],grid[i][j-1]);
                    min = Math.min(min,grid[i-1][j-1]);
                    grid[i][j] = min + 1;
                    maxLength = Math.max(maxLength,grid[i][j]);
                }
            }
        }
        return maxLength*maxLength;
    }
}
