package com.madhu.psds.matrix;
//https://leetcode.com/problems/valid-sudoku/
//36. Valid Sudoku

public class ValidSudoku {
    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        char[][] board = {
                {5, 3, '.', '.', 7, '.', '.', '.', '.'},
                {6, '.', '.', 1, 9, 5, '.', '.', '.'},
                {'.', 9, 8, '.', '.', '.', '.', 6, '.'},
                {8, '.', '.', '.', 6, '.', '.', '.', 3},
                {4, '.', '.', 8, '.', 3, '.', '.', 1},
                {7, '.', '.', '.', 2, '.', '.', '.', 6},
                {'.', 6, '.', '.', '.', '.', 2, 8, '.'},
                {'.', '.', '.', 4, 1, 9, '.', '.', 5},
                {'.', '.', '.', '.', 8, '.', '.', 7, 9}
        };
        validSudoku.isValidSudoku(board);
    }

    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(board[i][j] == '.') continue;
                if(!isSafe(board,i,j,rows,cols,board[i][j])) return false;
            }
        }
        return true;
    }

    boolean isSafe(char[][] board, int row, int col, int rows, int cols, char num) {
        //same row checking
        for (int i = 0; i < cols; i++) {
            if (i!=col && board[row][i] == num) return false;
        }

        //same col checking
        for (int i = 0; i < rows; i++) {
            if (i!=row && board[i][col] == num) return false;
        }

        //same grid checking
        int grid_size = (int) Math.sqrt(rows);
        int row_start = row - row % grid_size;
        int col_start = col - col % grid_size;
        int row_end = row_start + grid_size;
        int col_end = col_start + grid_size;
        for (int i = row_start; i < row_end; i++) {
            for (int j = col_start; j < col_end; j++) {
                if (i!=row && j!=col && board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
