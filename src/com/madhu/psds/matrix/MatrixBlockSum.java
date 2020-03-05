package com.madhu.psds.matrix;
//https://leetcode.com/problems/matrix-block-sum/
//1314. Matrix Block Sum

public class MatrixBlockSum {
    public static void main(String[] args) {
        int[][] m = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        MatrixBlockSum matrixBlockSum = new MatrixBlockSum();
        matrixBlockSum.matrixBlockSum(m,1);
    }

    public int[][] matrixBlockSum(int[][] mat, int K) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] result = new int[rows][cols];
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                int k = i - K;
                int l = i + K;
                int m = j - K;
                int n = j + K;
                result[i][j] = getSum(mat,k,l,m,n,rows,cols);
            }
        }
        return result;
    }

    public int getSum(int[][] input,int k,int l,int m,int n,int rows,int cols){
        int sum=0;
        for(int iStart = Math.max(0,k);iStart<=Math.min(l,rows-1);iStart++) {
            for(int jStart =  Math.max(0,m);jStart<=Math.min(n,cols-1);jStart++) {
                sum += input[iStart][jStart];
            }
        }
        return sum;
    }
}
