package com.madhu.psds.matrix;
//https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
//1351. Count Negative Numbers in a Sorted Matrix

public class CountNegativeNumbers {

    public int countNegatives(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        int j = columns - 1;
        int i = 0;
        while (j >= 0 && i < rows) {
            if (grid[i][j] < 0) {
                count = count + (rows - i);
                j--;
            } else {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{
//                {4, 3, 2, -1},
//                {3, 2, 1, -1},
//                {1, 1, -1, -2},
//                {-1, -1, -2, -3}
//        };
        int[][] matrix = new int[][]{
                {5,1,0},
                {-5,-5,-5}
        };
        CountNegativeNumbers countNegativeNumbers = new CountNegativeNumbers();
        countNegativeNumbers.countNegatives(matrix);
    }
}
