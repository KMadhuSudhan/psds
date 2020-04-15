package com.madhu.psds.matrix;
//https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
//1275. Find Winner on a Tic Tac Toe Game

public class WinnerOnTicTacToe {
    public static void main(String[] args) {
        WinnerOnTicTacToe winnerOnTicTacToe = new WinnerOnTicTacToe();
        int[][] moves = {
                {0, 0},
                {1, 1},
                {2, 0},
                {1, 0},
                {1, 2},
                {2, 1},
                {0, 1},
                {0, 2},
                {2, 2}
        };
        winnerOnTicTacToe.tictactoe(moves);
    }

    public String tictactoe(int[][] moves) {
        TicTacToe ticTacToe = new TicTacToe(3);
        String res = "";
        for (int i = 0; i < moves.length; i++) {
            res = ticTacToe.move(moves[i][0], moves[i][1], i % 2 == 0 ? "A" : "B");
        }
        if (res == null && moves.length == 9) {
            return "Draw";
        } else if (res == null) {
            return "Pending";
        } else {
            return res;
        }
    }

    class TicTacToe {
        private int[] rows;
        private int[] cols;
        private int diagnols;
        private int antidiagnols;

        public TicTacToe(int n) {
            rows = new int[n];
            cols = new int[n];
        }

        public String move(int row, int col, String player) {
            int add = player == "A" ? 1 : -1;
            rows[row] += add;
            cols[col] += add;

            if (row == col) {
                diagnols += add;
            }
            if (col == (cols.length - row - 1)) {
                antidiagnols += add;
            }
            int size = rows.length;

            if (Math.abs(rows[row]) == size
                    || Math.abs(cols[col]) == size
                    || Math.abs(diagnols) == size
                    || Math.abs(antidiagnols) == size) {
                return player;
            }
            return null;
        }
    }
}
