package com.madhu.psds.matrix;
//https://leetcode.com/problems/maximal-rectangle/
//85. Maximal Rectangle

import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        maximalRectangle.maximalRectangle(matrix);
    }

    public int maximalRectangle(char[][] grid) {
        int rows = grid.length;
        if(rows == 0) return 0;
        int cols = grid[0].length;
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = grid[i][j] == '1' ? 1 : 0;
            }
        }

        int result = maxHistogramArea(cols, matrix[0]);
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
            result = Math.max(result, maxHistogramArea(cols, matrix[i]));
        }
        System.out.println(result);
        return result;
    }

    int maxHistogramArea(int C, int[] row) {
        int area, maxArea = 0, i = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < C) {
            if (stack.isEmpty() || row[stack.peek()] <= row[i]) {
                stack.push(i++);
            } else {
                int topVal = row[stack.peek()];
                area = topVal * i;
                stack.pop();
                if (!stack.isEmpty()) {
                    area = topVal * (i - stack.peek() - 1);
                }
                maxArea = Math.max(maxArea, area);
            }
        }
        while (!stack.isEmpty()) {
            int top_val = row[stack.peek()];
            stack.pop();
            area = top_val * i;
            if (!stack.empty())
                area = top_val * (i - stack.peek() - 1);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
