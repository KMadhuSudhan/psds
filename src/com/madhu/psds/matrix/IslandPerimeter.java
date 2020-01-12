package com.madhu.psds.matrix;

public class IslandPerimeter {
    public static void main(String[] args) {

    }

    public int islandPerimeter(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    count += CheckRelatives(grid, i + 1, j)
                            + CheckRelatives(grid, i, j + 1)
                            + CheckRelatives(grid, i - 1, j)
                            + CheckRelatives(grid, i, j - 1);
                }
            }
        }
        return count;
    }

    public int CheckRelatives(int[][] grid, int row, int col) {


        if (row >= grid.length || row < 0 || col < 0 || col >= grid[row].length ||
                grid[row][col] == 0)
            return 1;

        return 0;
    }
}
