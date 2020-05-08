package com.madhu.psds.matrix;
//https://leetcode.com/problems/coloring-a-border/
//1034. Coloring A Border

public class ColoringABorder {
    int[][] directions = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };
    public static void main(String[] args) {
        ColoringABorder coloringABorder = new ColoringABorder();
        int[][] mat = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        coloringABorder.colorBorder(mat,0,0,3);
    }

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int rows = grid.length,cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        helper(grid, visited, r0, c0, grid[r0][c0], color);
        return grid;
    }

    private void helper(int[][] grid, boolean[][] visited, int x, int y, int oldColor, int newColor) {
        if (visited[x][y]) {
            return;
        }

        visited[x][y] = true;
        boolean isBorderCell = isBorderCell(grid, x, y, oldColor);

        for (int[] dir : directions) {
            int newX = x + dir[0],
                    newY = y + dir[1];

            if (isValid(grid, newX, newY) && grid[newX][newY] == oldColor && !visited[newX][newY]) {
                helper(grid, visited, newX, newY, oldColor, newColor);
            }
        }

        if (isBorderCell) {
            grid[x][y] = newColor;
        }
    }

    private boolean isValid(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }

    private boolean isBorderCell(int[][] grid, int x, int y, int oldColor) {
        return x == 0 || x == grid.length-1 || y == 0 || y == grid[0].length-1
                || (isValid(grid, x-1, y) && grid[x-1][y] != oldColor)
                || (isValid(grid, x, y-1) && grid[x][y-1] != oldColor)
                || (isValid(grid, x+1, y) && grid[x+1][y] != oldColor)
                || (isValid(grid, x, y+1) && grid[x][y+1] != oldColor);
    }
}
