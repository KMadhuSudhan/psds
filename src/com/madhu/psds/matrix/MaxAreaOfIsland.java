package com.madhu.psds.matrix;
//https://leetcode.com/problems/max-area-of-island/
//695. Max Area of Island

public class MaxAreaOfIsland {
    int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    int currentDfsCount = 0;

    public static void main(String[] args) {
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        int[][] grid = {
                {1, 1},
                {1, 0}
        };
        System.out.println(maxAreaOfIsland.maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        if (rows == 0) return 0;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (!visited[i][j] && grid[i][j] == 1) {
                    currentDfsCount = 0;
                    dfs(grid, i, j, rows, cols, visited);
                    max = Math.max(max, currentDfsCount);
                }
            }
        }
        return max;
    }

    void dfs(int[][] grid, int row, int col, int rows, int cols, boolean[][] visited) {
        if (visited[row][col]) return;
        currentDfsCount += 1;
        visited[row][col] = true;
        for (int[] direction : directions) {
            int dx = row + direction[0];
            int dy = col + direction[1];
            if (dx < 0 || dy < 0 || dx >= rows || dy >= cols || grid[dx][dy] == 0) {
                continue;
            }
            dfs(grid, dx, dy, rows, cols, visited);
        }
    }
}
