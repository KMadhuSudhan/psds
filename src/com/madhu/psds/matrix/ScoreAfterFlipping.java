package com.madhu.psds.matrix;
//https://leetcode.com/problems/score-after-flipping-matrix/
//861. Score After Flipping Matrix

public class ScoreAfterFlipping {
    public static void main(String[] args) {
        int[][] m = {
                {0,0,1,1},
                {1,0,1,0},
                {1,1,0,0}
        };
        ScoreAfterFlipping scoreAfterFlipping = new ScoreAfterFlipping();
        scoreAfterFlipping.matrixScore(m);
    }

    public int matrixScore(int[][] A) {
        int R = A.length, C = A[0].length;
        int ans = 0;
        for (int c = 0; c < C; ++c) {
            int col = 0;
            for (int r = 0; r < R; ++r)
                col += A[r][c] ^ A[r][0];
            ans += Math.max(col, R - col) * (1 << (C-1-c));
        }
        return ans;
    }
}
