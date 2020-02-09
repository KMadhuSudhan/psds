package com.madhu.psds.matrix;
//https://leetcode.com/problems/number-of-closed-islands/
//1254. Number of Closed Islands

public class ClosedIslands {
    public static void main(String[] args) {
        int[][] matrx = {};
        ClosedIslands closedIslands = new ClosedIslands();
        closedIslands.closedIsland(matrx);
    }

    public int closedIsland(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (grid[row][column] == 1 && !visited[row][column]) {
                    dfs(grid, visited, row, column, rows, columns);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int[][] grid, boolean[][] visited, int row, int column, int rows, int columns) {
        int rowNbr[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int colNbr[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        visited[row][column] = true;
        for (int k = 0; k < 8; k++) {
            if (isSafe(grid, row + rowNbr[k], column + colNbr[k], visited, rows, columns)) {
                dfs(grid, visited, row, column, rows, columns);
            }
        }
    }

    boolean isSafe(int M[][], int row, int col, boolean visited[][], int rows, int columns) {
        return (row >= 0) && (row < rows) && (col >= 0) && (col < columns) && (M[row][col] == 1 && !visited[row][col]);
    }
}
