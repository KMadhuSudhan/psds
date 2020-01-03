package com.madhu.psds.matrix;

public class TransposeMatrix {
    public static void main() {
        int[][] A = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        TransposeMatrix transposeMatrix = new TransposeMatrix();
        transposeMatrix.transpose(A);
    }

    public int[][] transpose(int[][] A) {
        int b[][] = new int[A[0].length][A.length];
        for (int i = 0; i < A[0].length; i++) {
            for (int j = 0; j < A.length; j++) {
                b[i][j] = A[j][i];
            }
        }
        return b;
    }
}
