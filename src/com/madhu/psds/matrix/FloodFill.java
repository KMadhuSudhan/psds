package com.madhu.psds.matrix;
//https://leetcode.com/problems/flood-fill/submissions/
//733. Flood Fill

public class FloodFill {
    int[][] directions = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };
    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();
        int[][] mat = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        floodFill.floodFill(mat,1,1,2);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        if(rows == 0) return image;
        int cols = image[0].length;
        int sourceColor = image[sr][sc];
        boolean[][] visited = new boolean[rows][cols];
        dfs(image,sr,sc,sourceColor,newColor,visited,rows,cols);
        return image;
    }
    void dfs(int[][] image,int row,int col,int sourceColor,int newColor,boolean[][] visited,int rows,int cols ) {
        if(image[row][col] != sourceColor || visited[row][col]) return;
        image[row][col] = newColor;
        visited[row][col] = true;
        for(int[] direction: directions) {
            int dx = row + direction[0];
            int dy = col + direction[1];
            if(dx < 0 || dy < 0 || dx>=rows || dy >= cols) continue;
            dfs(image,dx,dy,sourceColor,newColor,visited,rows,cols);
        }
    }
}
