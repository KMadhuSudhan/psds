package com.madhu.psds.matrix;
//https://leetcode.com/problems/rotate-image/
//48. Rotate Image

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(matrix);
    }
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i=0;i<rows;i++) {
            for(int j=i+1;j<cols;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
            reverseRow(matrix[i],cols);
        }
    }
    void reverseRow(int[] row,int cols) {
        int low=0;
        int high=cols-1;
        while(low<high) {
            int temp = row[low];
            row[low] = row[high];
            row[high] = temp;
            low++;
            high--;
        }
    }
}
