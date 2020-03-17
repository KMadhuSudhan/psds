package com.madhu.psds.matrix;
//https://leetcode.com/problems/sudoku-solver/
//37. Sudoku Solver

public class SudokuSolver {
    public static void main(String[] args) {
        SudokuSolver sudokuSolver = new SudokuSolver();
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
        sudokuSolver.solveSudoku(board);
        sudokuSolver.print(board);
    }

    public void solveSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        solveSudoku(board, rows, cols);
    }

    public boolean solveSudoku(char[][] board, int rows, int cols) {
        int row = -1;
        int col = -1;
        boolean isEmpty = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '.') {
                    isEmpty = true;
                    row = i;
                    col = j;
                    break;
                }
            }
            if (isEmpty) break;
        }
        if (isEmpty == false) {
            return true;
        }
        for (char i = '1'; i <= '9'; i++) {
            if (isSafe(board, row, col, rows, cols, i)) {
                board[row][col] = i;
                if (solveSudoku(board, rows, cols)) {
                    return true;
                } else {
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }

    boolean isSafe(char[][] board, int row, int col, int rows, int cols, char num) {
        //same row checking
        for (int i = 0; i < cols; i++) {
            if (board[row][i] == num) return false;
        }

        //same col checking
        for (int i = 0; i < rows; i++) {
            if (board[i][col] == num) return false;
        }

        //same grid checking
        int grid_size = (int) Math.sqrt(rows);
        int row_start = row - row % grid_size;
        int col_start = col - col % grid_size;
        int row_end = row_start + grid_size;
        int col_end = col_start + grid_size;
        for (int i = row_start; i < row_end; i++) {
            for (int j = col_start; j < col_end; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    void print(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print((int) (board[i][j] - '0'));
            }
            System.out.println();
        }
    }
}
