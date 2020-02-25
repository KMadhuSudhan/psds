package com.madhu.psds.matrix;
//https://leetcode.com/problems/set-matrix-zeroes/submissions/
//73. Set Matrix Zeroes

public class SetMatrixZeros {
    public static void main(String[] args) {
//        int[][] matrx = new int[][]{
//                {1, 1, 1},
//                {1, 0, 1},
//                {1, 1, 1}
//        };
        int[][] mat1 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        SetMatrixZeros setMatrixZeros = new SetMatrixZeros();
        setMatrixZeros.setZeroes(mat1);
    }

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        setValues(matrix, rows, columns);
        setZeroes(matrix, rows, columns);
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                System.out.print(" " + matrix[i][j]);
//            }
//            System.out.println();
//        }
    }

    public void setValues(int[][] matrix, int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 0) {
                    setRowZero(matrix, i, columns);
                    setColumnZero(matrix, j, rows);
                }
            }
        }
    }

    public void setZeroes(int[][] matrix, int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '*') {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setRowZero(int[][] matrix, int row, int columns) {
        for (int col = 0; col < columns; col++) {
//            if(matrix[row][col] == '*' ) break;
            if(matrix[row][col] == 0 ) continue;
            matrix[row][col] = '*';
        }
    }

    public void setColumnZero(int[][] matrix, int column, int rows) {
        for (int row = 0; row < rows; row++) {
//            if(matrix[row][column] == '*' ) break;
            if(matrix[row][column] == 0 ) continue;
            matrix[row][column] = '*';
        }
    }
}
