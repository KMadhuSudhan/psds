package com.madhu.psds.geometry;
//https://leetcode.com/problems/triangle/
//120. Triangle

import java.util.List;

public class Triangle {
    public static void main(String[] args) {
//        [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
    }
    public int minimumTotalRec(List<List<Integer>> triangle, int level, int ind, Integer[][] memo) {
        if (level == triangle.size()) return 0; // reached last level
        if (memo[level][ind] != null) return memo[level][ind]; // the value for current level and index has been already calculated
        // store the minimum between the following 2 options
        memo[level][ind] = Math.min(minimumTotalRec(triangle, level + 1, ind, memo), // next level and current index
                minimumTotalRec(triangle, level + 1, ind + 1, memo)) + // next level and index + 1
                triangle.get(level).get(ind); // plus the value of current node
        return memo[level][ind]; // return calculated value
    }

    //without recursive
    public int minimumTotalRec(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int columns = triangle.get(rows-1).size();
        int[][] result = new int[triangle.size()][columns];
        for(int i = 0 ;i< columns;i++) {
            result[rows-1][i] = triangle.get(rows-1).get(i);
        }
        for(int i=rows-2;i>=0;i--) {
            int columnSize = triangle.get(i).size();
            for (int j=0;j<columnSize;j++) {
                result[i][j] = Math.min(result[i+1][j],result[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return result[0][0];
    }
}
