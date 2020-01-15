package com.madhu.psds.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        RottingOranges rottingOranges = new RottingOranges();
        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
        rottingOranges.orangesRotting(grid);
    }
    public int orangesRotting(int[][] grid) {
        if (grid == null) return -1;

        int rows = grid.length;
        if (rows == 0) return -1;

        int cols = grid[0].length;
        if (cols == 0) return -1;

        int freshCounts = 0;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1)
                    freshCounts++;
            }
        }

        if (freshCounts == 0) return freshCounts;
        return bfs(grid, queue, freshCounts);
    }

    private int bfs(int[][] grid, Queue<int[]> queue, int freshCounts) {
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int days = 0;
        // fresh count can be zero, even though some rotten oranges can be in the queue
        // in that case, we do not need to process those and simply return the result
        while (!queue.isEmpty() && freshCounts > 0) {
            days++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                for (int[] direction : directions) {
                    int x = current[0] + direction[0];
                    int y = current[1] + direction[1];

                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) { // if valid
                        if (grid[x][y] == 1) { // rot only the fresh orange
                            grid[x][y] = 2;
                            queue.add(new int[]{x, y});
                            freshCounts--; // fresh count is decresed
                        }
                    }
                }
            }
        }
        return freshCounts == 0 ? days : -1;
    }
}