package com.madhu.psds.matrix;
//https://leetcode.com/problems/unique-paths-ii/
//63. Unique Paths II

public class UniquePathsII {
    public static void main(String[] args) {
        UniquePathsII uniquePathsII = new UniquePathsII();
        int[][] m = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(uniquePathsII.uniquePathsWithObstacles(m));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || (rows == 0 && cols == 0)) return 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = -1;
                }
            }
        }
        obstacleGrid[0][0] = 1;
        for (int i = 1; i < rows; i++) {
            if (obstacleGrid[i][0] == -1) break;
            obstacleGrid[i][0] = 1;
        }

        for (int i = 1; i < cols; i++) {
            if (obstacleGrid[0][i] == -1) break;
            obstacleGrid[0][i] = 1;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if(obstacleGrid[i][j] == -1 || (obstacleGrid[i-1][j] == -1 && obstacleGrid[i][j-1] == -1)) continue;
                if(obstacleGrid[i-1][j] == -1) {
                    obstacleGrid[i][j] = obstacleGrid[i][j-1];
                    continue;
                }
                if(obstacleGrid[i][j-1] == -1) {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j];
                    continue;
                }
                obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }
        return obstacleGrid[rows - 1][cols - 1] == -1 ? 0 : obstacleGrid[rows - 1][cols - 1];
    }

    public int uniquePathsWithObstaclesWithExtraMemory(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        if (n == 0) return 0;
        int m = obstacleGrid[0].length;
        if (m == 0) return 0;
        if(obstacleGrid[0][0] ==1) return 0;
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == 1) break;
            map[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] == 1) break;
            map[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                map[i][j] = obstacleGrid[i][j] == 1 ? 0 : map[i - 1][j] + map[i][j - 1];
            }
        }
        return map[n - 1][m - 1];
    }
}
