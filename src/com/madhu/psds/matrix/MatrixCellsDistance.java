package com.madhu.psds.matrix;

import java.util.*;

public class MatrixCellsDistance {
    public static void main(String[] args) {
        MatrixCellsDistance matrixCellsDistance = new MatrixCellsDistance();
        int R, C, r0, c0;
        R = 2;
        C = 2;
        r0 = 0;
        c0 = 1;
        matrixCellsDistance.allCellsDistOrder(R, C, r0, c0);
    }

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] sol = new int[R * C][2];
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        q.offer(new int[]{r0, c0});
        int i = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            if (r < 0 || c < 0 || r >= R || c >= C)
                continue;
            if (visited[r][c])
                continue;
            visited[r][c] = true;
            sol[i++] = curr;
            q.offer(new int[]{r, c + 1});
            q.offer(new int[]{r, c - 1});
            q.offer(new int[]{r + 1, c});
            q.offer(new int[]{r - 1, c});
        }
        return sol;
    }
}
