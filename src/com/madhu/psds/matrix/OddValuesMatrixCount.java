package com.madhu.psds.matrix;

public class OddValuesMatrixCount {
    public static void main(String[] args) {
        int n = 2, m = 3;
        int[][] indices = new int[][]{{0, 1}, {1, 1}};
        OddValuesMatrixCount oddValuesMatrixCount = new OddValuesMatrixCount();
        System.out.println(oddValuesMatrixCount.oddCells(n, m, indices));
    }

    public int oddCells(int n, int m, int[][] indices) {
        int length = indices.length;
        int i,j,k;
        int oddCount = 0;
        int[][] matrix = new int[n][m];
        for(i = 0; i < length;i++ ) {
            int row = indices[i][0];
            int column = indices[i][1];
            for(j=0;j<n;j++) {
                matrix[j][column]+=1;
            }
            for(k=0;k<m;k++) {
                matrix[row][k]+=1;
            }
        }
        for(i=0;i<n;i++) {
            for(j=0;j<m;j++) {
                if(matrix[i][j]%2 == 1) oddCount++;
            }
        }
        return oddCount;
    }
}
