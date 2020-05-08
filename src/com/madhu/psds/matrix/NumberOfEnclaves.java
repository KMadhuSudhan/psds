package com.madhu.psds.matrix;
//https://leetcode.com/problems/number-of-enclaves/
//1020. Number of Enclaves

public class NumberOfEnclaves {
    public static void main(String[] args) {
        int[][] matrix = {
                {0,0,0,0},
                {1,0,1,0},
                {0,1,1,0},
                {0,0,0,0}
        };
        NumberOfEnclaves numberOfEnclaves = new NumberOfEnclaves();
        numberOfEnclaves.numEnclaves(matrix);
    }

    public int numEnclaves(int[][] A) {
        if(A == null || A.length == 0)
            return 0;

        int rows = A.length;
        int cols = A[0].length;

        /**
         * Do a DFS from left most & right most columns (borders) that are having 1, mark all the
         * connected lands 1 to 0.
         */
        int count = 0;
        for(int i=0; i<rows; i++){
            if(A[i][0] == 1){
                dfs(A, i, 0);
            }

            if(A[i][cols-1] == 1){
                dfs(A, i, cols-1);
            }
        }

        /**
         * Do a DFS from top & bottom (borders) that are having 1, mark all the
         * connected lands 1 to 0.
         */
        for(int j=0; j<cols; j++){
            if(A[0][j] == 1){
                dfs(A, 0, j);
            }

            if(A[rows-1][j] == 1){
                dfs(A, rows-1, j);
            }
        }

        /**
         *  Now count the numbers cells that are left with 1 (land).
         */
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(A[i][j] == 1)
                    count++;
            }
        }

        return count;
    }

    private void dfs(int[][] A, int i, int j){

        if(i<0 || i>=A.length || j<0 || j>=A[0].length || A[i][j] == 0)
            return;

        A[i][j] = 0;
        dfs(A, i+1, j);
        dfs(A, i-1, j);
        dfs(A, i, j+1);
        dfs(A, i, j-1);
    }
}
