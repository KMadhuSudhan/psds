package com.madhu.psds.matrix;

public class UniqPathsIII {
    int ans = 0;
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };
        UniqPathsIII uniqPathsIII = new UniqPathsIII();
        System.out.println(uniqPathsIII.uniquePathsIII(matrix));
    }

    public int uniquePathsIII(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int row = 0;
        int col = 0;
        int counted_zeros = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == 0) counted_zeros++;
                if (grid[i][j] == 1) {
                    row = i;
                    col = j;
                }
            }
        }
        dfs(grid, visited,0, counted_zeros,row, col, rows, cols);
        return ans;
    }

    public void dfs(int[][] grid, boolean[][] visited,int current_zeros,int counted_zeros, int row, int col, int rows, int cols) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || grid[row][col] == -1) return;
        visited[row][col] = true;
        if(grid[row][col] == 0) current_zeros++;
        if (grid[row][col] == 2) {
            if(current_zeros == counted_zeros) ans++;
            visited[row][col] = false;
        } else {
            dfs(grid, visited,current_zeros,counted_zeros,row - 1, col, rows, cols);
            dfs(grid, visited,current_zeros,counted_zeros,row + 1, col, rows, cols);
            dfs(grid, visited,current_zeros,counted_zeros, row, col - 1, rows, cols);
            dfs(grid, visited,current_zeros,counted_zeros, row, col + 1, rows, cols);
            visited[row][col] = false;
        }
    }
}
