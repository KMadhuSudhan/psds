package com.madhu.psds.matrix;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/spiral-matrix/submissions/
//54. Spiral Matrix

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rows = matrix.length;
        if(rows == 0) return list;
        int columns = matrix[0].length;
        int last_row = rows - 1;
        int last_column = columns - 1;
        int i, l = 0, k = 0;
        while (l <= last_column && k <= last_row) {
            for (i = l; i <= last_column; i++) {
                list.add(matrix[k][i]);
            }
            k++;
            for (i = k; i <= last_row; i++) {
                list.add(matrix[i][last_column]);
            }
            last_column--;
            if (k <= last_row) {
                for (i = last_column; i >= l; i--) {
                    list.add(matrix[last_row][i]);
                }
                last_row--;
            }
            if (l <= last_column) {
                for (i = last_row; i >= k; i--) {
                    list.add(matrix[i][l]);
                }
                l++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] m = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        spiralMatrix.spiralOrder(m);
    }
}
