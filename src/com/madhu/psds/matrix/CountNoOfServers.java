package com.madhu.psds.matrix;
//https://leetcode.com/problems/count-servers-that-communicate/
//1267. Count Servers that Communicate

public class CountNoOfServers {
    public static void main(String[] args) {
        CountNoOfServers countNoOfServers = new CountNoOfServers();
//        int[][] grid = {
//                {1, 1, 0, 0},
//                {0, 0, 1, 0},
//                {0, 0, 1, 0},
//                {0, 0, 0, 1}
//        };
        int[][] grid = {
                {1, 0},
                {1, 1}
        };
        countNoOfServers.countServers(grid);
      //  System.out.println(countNoOfServers.countServers(grid));
    }

    public int countServers(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] rowServers = new int[rows];
        int[] colServer = new int[cols];
        for (int i = 0; i < rows; i++) {
            int serverCount = 0;
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) {
                    serverCount++;
                    colServer[j]++;
                }
            }
           rowServers[i] = serverCount;
        }
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == 1 && (rowServers[i] > 1 || colServer[j] >1)) {
                    count++;
                }
            }
        }
        return count;
    }
}
