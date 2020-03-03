package com.madhu.psds.matrix;
//https://leetcode.com/problems/search-a-2d-matrix/submissions/
//74. Search a 2D Matrix

public class SearchInSorted {
    public static void main(String[] args) {
        int[][] m = new int[][]{{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
//        int[][] m = new int[][]{{1},{3}};

        SearchInSorted searchInSorted = new SearchInSorted();
        System.out.println(searchInSorted.searchMatrix(m,3));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if(rows ==0) return false;
        int cols = matrix[0].length;
        int i=0;
        int j = cols-1;
        while (i < rows && j>=0) {
            if(matrix[i][j] == target) return true;
            if(matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
