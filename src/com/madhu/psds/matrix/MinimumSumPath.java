package com.madhu.psds.matrix;
//https://leetcode.com/problems/minimum-path-sum/
//64. Minimum Path Sum

public class MinimumSumPath {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        MinimumSumPath minimumSumPath = new MinimumSumPath();
        minimumSumPath.minPathSum(matrix);
    }

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 1; i < rows; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < cols; i++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < rows; j++) {
                grid[i][j] = Math.min(grid[i][j] + grid[i - 1][j], grid[i][j - 1] + grid[i][j]);
            }
        }
        return grid[rows - 1][cols - 1];
    }
}
