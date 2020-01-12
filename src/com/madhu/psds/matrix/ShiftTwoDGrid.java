package com.madhu.psds.matrix;

import java.util.ArrayList;
import java.util.List;

public class ShiftTwoDGrid {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ShiftTwoDGrid shiftTwoDGrid = new ShiftTwoDGrid();
        shiftTwoDGrid.shiftGrid(grid, 1);
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> listList = new ArrayList<>();
        int rows = grid.length;
        int columns = grid[0].length;
        while (k > 0) {
            int temp = grid[rows - 1][columns - 1];
            for (int i = rows - 1; i >= 0; i--) {
                for (int j = columns - 2; j >= 0; j--) {
                    grid[i][j + 1] = grid[i][j];
                }
                if (i != 0) {
                    grid[i][0] = grid[i - 1][columns - 1];
                }
            }
            grid[0][0] = temp;
            k--;
        }
        for (int i = 0; i < rows; i++) {
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                subList.add(grid[i][j]);
            }
            listList.add(subList);
        }
        return listList;
    }
}
