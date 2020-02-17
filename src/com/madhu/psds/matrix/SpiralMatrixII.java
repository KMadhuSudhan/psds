package com.madhu.psds.matrix;
//https://leetcode.com/problems/spiral-matrix-ii/
//59. Spiral Matrix II


public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) return matrix;
        int rows = n;
        int columns = n;
        int last_row = rows - 1;
        int last_column = columns - 1;
        int i, l = 0, k = 0;
        int count = 1;
        while (l <= last_column && k <= last_row) {
            for (i = l; i <= last_column; i++) {
                matrix[k][i] = count++;
            }
            k++;
            for (i = k; i <= last_row; i++) {
                matrix[i][last_column] = count++;
            }
            last_column--;
            if (k <= last_row) {
                for (i = last_column; i >= l; i--) {
                    matrix[last_row][i] = count++;
                }
                last_row--;
            }
            if (l <= last_column) {
                for (i = last_row; i >= k; i--) {
                    matrix[i][l] = count++;
                }
                l++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrixII spiralMatrix = new SpiralMatrixII();
        int[][] m = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        spiralMatrix.generateMatrix(3);
    }
}
