package com.madhu.psds.flipping;

public class FlipAndInvertImage {
    public static void main(String[] args) {
        int[][] x = new int[][]{{1,1,0},{1,0,1},{0,0,0}};
        System.out.print(flipAndInvertImage(x));
    }
    private static int[][] flipAndInvertImage(int[][] x) {
        int rows = x.length;
        int columns = x[0].length;
        int i,j,k;
        for(i =0;i<rows;i++) {
            j = columns-1;
            k =0;
            while(k<=j) {
                int temp = x[i][j] ^ 1;
                x[i][j] = x[i][k] ^ 1;
                x[i][k] = temp;
                k++;
                j--;
            }
        }
        return x;
    }
}
