package com.madhu.psds.matrix;

import java.util.HashMap;
import java.util.Map;

public class SpiralMatrixIII {
    public static void main(String[] args) {
        SpiralMatrixIII spiralMatrixIII = new SpiralMatrixIII();
        int R = 5, C = 6, r0 = 1, c0 = 4;
        spiralMatrixIII.spiralMatrixIII(R,C,r0,c0);
    }

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int i=0;
        int left=0;
        int right=0;
        int up=0;
        int down=0;
        int[][] ans = new int[R*C][2];
        while (i < R*C) {

            //right
            ans[i++] = new int[]{r0,c0};
            c0++;
            ans[i++] = new int[]{r0,c0};

            //down
            r0++;
            ans[i++] = new int[]{r0,c0};

            //left
            c0--;
            ans[i++] = new int[]{r0,c0};
            c0--;
            ans[i++] = new int[]{r0,c0};

            //up
            r0--;
            ans[i++] = new int[]{r0,c0};
            r0--;
            ans[i++] = new int[]{r0,c0};
        }
        return null;
    }
}
