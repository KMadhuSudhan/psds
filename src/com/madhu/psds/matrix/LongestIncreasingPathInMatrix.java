package com.madhu.psds.matrix;

public class LongestIncreasingPathInMatrix {
    int[][] directions = {
            {-1,0},
            {1,0},
            {0,1},
            {0,-1}
    };
    public static void main(String[] args) {

    }
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        if(matrix != null && matrix.length > 0){
            int R = matrix.length;
            int C = matrix[0].length;
            int i, j;

            int[][] memo = new int[R][C];

            for(i = 0; i < R; i++){
                for(j = 0; j < C; j++){
                    max = Math.max(max, DFS(matrix, memo, i, j, R, C));
                }
            }
        }
        return max;
    }

    private int DFS(int[][] matrix, int[][] memo, int i, int j, int R, int C){
        if(memo[i][j] == 0){
            int max = 1, dx, dy;
            for(int[] direction : directions){
                dx = i + direction[0];
                dy = j + direction[1];

                if(dx < 0 || dx >= R || dy < 0 || dy >= C || matrix[dx][dy] <= matrix[i][j])
                    continue;
                max = Math.max(max, 1 + DFS(matrix, memo, dx, dy, R, C));
            }

            memo[i][j] = max;
        }

        return memo[i][j];
    }
}
