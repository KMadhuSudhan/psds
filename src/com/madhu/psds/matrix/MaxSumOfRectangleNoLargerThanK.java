package com.madhu.psds.matrix;

import java.util.TreeSet;
//https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/
//363. Max Sum of Rectangle No Larger Than K

public class MaxSumOfRectangleNoLargerThanK {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,0,1},
                {0,-2,3}
        };
        MaxSumOfRectangleNoLargerThanK maxSumOfRectangleNoLargerThanK = new MaxSumOfRectangleNoLargerThanK();
        System.out.println(maxSumOfRectangleNoLargerThanK.maxSumSubmatrix(matrix,2));
    }
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] colArray = new int[rows];
        int max = Integer.MIN_VALUE;
        for (int i=0;i<cols;i++) {
            for(int q = 0; q < rows; q++){
                colArray[q] = 0;
            }
            for (int j=i;j<cols;j++) {
                for (int p=0;p<rows;p++) {
                    colArray[p] += matrix[p][j];
                }
                max = Math.max(max, kadanes(colArray, k));
                if (max == k) { return k; }
            }
        }
        return max;
    }

    int kadanes(int[] arr,int k) {
        int max = Integer.MIN_VALUE;
        int curr = 0;

        // Create tree set to find local maximum with respect to k
        TreeSet<Integer> set = new TreeSet<>();

        // Populate with 0 for the case where curr - k is smaller than 0
        set.add(0);
        for (int i = 0; i < arr.length; i++) {
            curr += arr[i];

            // Use the previous sums to determine the smallest previous sum. that can be subtracted from the
            // current sum to stay under the value k, by taking the ceiling value for curr - k
            Integer ceil = set.ceiling(curr - k);
            if(ceil != null) {
                max = Math.max(max, curr - ceil);
            }
            set.add(curr);
        }
        return max;
    }
}
