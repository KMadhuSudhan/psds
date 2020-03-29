package com.madhu.psds.matrix;
//https://leetcode.com/problems/01-matrix/
//542. 01 Matrix

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceBetweenTwoCells {
    public static void main(String[] args) {
        int[][] m = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        DistanceBetweenTwoCells distanceBetweenTwoCells = new DistanceBetweenTwoCells();
        int[][] result  = distanceBetweenTwoCells.updateMatrix(m);
        distanceBetweenTwoCells.print(result);
    }

    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        if(rows == 0) return matrix;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];

        for(int[] row: result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                }
            }
        }
        int length = 1;
        int[][] OFFSETS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] loc = q.poll();
                int x = loc[0];
                int y = loc[1];

                for(int[] OFFSET: OFFSETS) {
                    int newX = x + OFFSET[0];
                    int newY = y + OFFSET[1];
                    if(inArea(newX, newY,rows,cols) && result[newX][newY] > length) {
                        result[newX][newY] = length;
                        q.offer(new int[]{newX, newY});
                    }
                }
            }
            length++;
        }
        return result;
    }

    private boolean inArea(int x, int y,int m,int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    void print(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
