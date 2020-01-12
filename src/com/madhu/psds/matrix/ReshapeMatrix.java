package com.madhu.psds.matrix;

import java.util.HashMap;
import java.util.Map;

public class ReshapeMatrix {
    Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2}, {3, 4}};
        ReshapeMatrix reshapeMatrix = new ReshapeMatrix();
        reshapeMatrix.matrixReshape(matrix, 1, 4);
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int rows = nums.length;
        int cols = nums[0].length;
        if (r * c == (rows * cols)) {
            int[][] n = new int[r][c];
            int index1 = 0;
            int index2 = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    n[i][j] = nums[index1][index2];
                    index2++;
                    if (index2 == cols) {
                        index1++;
                        index2 = 0;
                    }

                }
            }
            return n;
        } else {
            return nums;
        }
    }
}
