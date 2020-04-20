package com.madhu.psds.matrix;

public class MagicSquaresInGrid {
    int ans = 0;
    public static void main(String[] args) {
//        int[][] magic = {
//                {4, 3, 8, 4},
//                {9, 5, 1, 9},
//                {2, 7, 6, 2}
//        };
        int[][] magic = {
                {3,2,9,2,7},
                {6,1,8,4,2},
                {7,5,3,2,7},
                {2,9,4,9,6},
                {4,3,8,2,5}
        };
        MagicSquaresInGrid magicSquaresInGrid = new MagicSquaresInGrid();
        System.out.println(magicSquaresInGrid.numMagicSquaresInside(magic));
    }

    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (rows < 3 || cols < 3) return 0;
        int count = 0;
        for (int i=0;i<rows-2;i++) {
            for (int j=0;j<cols-2;j++) {
                if(grid[i+1][j+1]!=5) continue;
                if(numMagicSquaresInside(grid,i, j)) count++;
            }
        }
        return count;
    }

    public boolean numMagicSquaresInside(int[][] grid,int rowStart,int colStart) {
        int diagonalsSum = 0;
        int[] rowsSum = new int[3];
        int[] colsSum = new int[3];
        int antiDiagonalSum = 0;
        int[] numbers = new int[9];
        for (int i = rowStart,row =0; i < rowStart + 3; i++,row++) {
            for (int j = colStart,col=0; j < colStart + 3; j++,col++) {
                if(grid[i][j] > 9 || grid[i][j] < 1) return false;
                rowsSum[i%3] += grid[i][j];
                colsSum[j%3] += grid[i][j];
                if(numbers[grid[i][j]-1] == 0) {
                    numbers[grid[i][j]-1]++;
                } else {
                    return false;
                }
                if (row == col) diagonalsSum += grid[i][j];
                if ((3 - row - 1) == col) antiDiagonalSum += grid[i][j];
            }
        }
        if(diagonalsSum != antiDiagonalSum) return false;
        boolean isRowsEqual = rowsSum[0] == rowsSum[1]  && rowsSum[1] == rowsSum[2];
        boolean isColsEqual = colsSum[0] == colsSum[1]  && colsSum[1] == colsSum[2];
        return isRowsEqual && isColsEqual;
    }
}
