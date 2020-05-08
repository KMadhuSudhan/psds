package com.madhu.psds.matrix;
//https://leetcode.com/problems/surrounded-regions/
//130. Surrounded Regions

public class SurroundedRegions {
    int[][] directions = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };
    public static void main(String[] args) {
        char[][] matrix = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        surroundedRegions.solve(matrix);
    }
    public void solve(char[][] board) {
        int rows = board.length;
        if(rows == 0) return;
        int cols = board[0].length;
        for(int i=0;i<cols;i++) {
            if(board[0][i] == 'O') {
                dfs(board,0,i,rows,cols);
            }
        }

        for(int i=1;i<rows;i++) {
            if(board[i][0] == 'O') {
                dfs(board,i,0,rows,cols);
            }
        }

        for(int i=1;i<rows;i++) {
            if(board[i][cols-1] == 'O') {
                dfs(board,i,cols-1,rows,cols);
            }
        }

        for(int i=1;i<cols-1;i++) {
            if(board[rows-1][i] == 'O') {
                dfs(board,rows-1,i,rows,cols);
            }
        }

        for(int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                if(board[i][j] == '*') {
                    board[i][j] = 'O';
                }


            }
        }
    }

    public void dfs(char[][] board,int row,int col,int rows,int cols) {
        if(board[row][col]!='O') return;
        board[row][col] = '*';
        for (int[] direction: directions) {
            int dx = row + direction[0];
            int dy = col + direction[1];
            if(dx<0 || dx>=rows || dy>=cols || dy<0) continue;
            dfs(board,dx,dy,rows,cols);
        }
    }
}
