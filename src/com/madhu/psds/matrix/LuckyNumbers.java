package com.madhu.psds.matrix;
//https://leetcode.com/problems/lucky-numbers-in-a-matrix/
//1380. Lucky Numbers in a Matrix

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbers {
    public static void main(String[] args) {
        int[][] matrix = {
                {3,7,8},
                {9,11,13},
                {15,16,17}
        };
        LuckyNumbers luckyNumbers = new LuckyNumbers();
        luckyNumbers.luckyNumbers(matrix);
    }
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] minRow = new int[rows];
        int[] maxCol = new int[cols];

        for (int i=0;i<rows;i++) {
            int min = getMinInRow(matrix,i);
            minRow[i] = min;
        }

        for (int i=0;i<cols;i++) {
            int min = getMaxInCol(matrix,i);
            maxCol[i] = min;
        }
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if(minRow[i] == maxCol[j]) list.add(minRow[i]);
            }
        }
        return list;
    }

    private int getMinInRow(int[][] matrix,int row) {
        int min = matrix[row][0];
        for (int i=1;i<matrix[0].length;i++) {
            min = Math.min(min,matrix[row][i]);
        }
        return min;
    }

    private int getMaxInCol(int[][] matrix,int col) {
        int max = matrix[0][col];
        for (int i=1;i<matrix.length;i++) {
            max = Math.max(max,matrix[i][col]);
        }
        return max;
    }
}
