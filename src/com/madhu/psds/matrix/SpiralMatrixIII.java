package com.madhu.psds.matrix;
//https://leetcode.com/problems/spiral-matrix-iii/
//885. Spiral Matrix III


public class SpiralMatrixIII {
    public static void main(String[] args) {
        SpiralMatrixIII spiralMatrixIII = new SpiralMatrixIII();
        int R = 1, C = 4, r0 = 0, c0 = 0;
        int[][] ans = spiralMatrixIII.spiralMatrixIII(R, C, r0, c0);
        spiralMatrixIII.print(ans);
    }

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int i = 0;
        int left = 2;
        int right = 1;
        int up = 2;
        int down = 1;
        int k;
        int[][] ans = new int[R * C][2];
        ans[i++] = new int[]{r0, c0};

        while (i < R * C) {

            //right
            for (k = 0; k < right && i < R * C; k++) {
                if (++c0 >= C || r0 < 0 || c0 < 0 || r0 >= R) {
                    continue;
                }
                ans[i++] = new int[]{r0, c0};
            }

            //down
            for (k = 0; k < down && i < R * C; k++) {
                if (++r0 >= R || c0 >= C || c0 < 0 || r0 < 0) {
                    continue;
                }
                ans[i++] = new int[]{r0, c0};
            }

            //left
            for (k = 0; k < left && i < R * C; k++) {
                if (--c0 < 0 || r0 >= R || c0 >= C || r0 < 0) {
                    continue;
                }
                ans[i++] = new int[]{r0, c0};
            }


            //up
            for (k = 0; k < up && i < R * C; k++) {
                if (--r0 < 0 || r0 >= R || c0 >= C || c0 < 0) {
                    continue;
                }
                ans[i++] = new int[]{r0, c0};
            }

            right += 2;
            down += 2;
            left += 2;
            up += 2;
        }
        return ans;
    }

    private void print(int[][] m) {
        int rows = m.length;
        System.out.println(rows);
        for (int i = 0; i < rows; i++) {
            System.out.print("[" + m[i][0] + "," + m[i][1] + "]");
        }
    }
}
