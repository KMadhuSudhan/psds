package com.madhu.psds.matrix;

import javafx.util.Pair;

import java.util.*;

//1329. Sort the Matrix Diagonally
//https://leetcode.com/problems/sort-the-matrix-diagonally/
public class SortTheMatrixDiagonal {
    public static void main(String[] args) {
        int[][] m = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        SortTheMatrixDiagonal sortTheMatrixDiagonal = new SortTheMatrixDiagonal();
        sortTheMatrixDiagonal.diagonalSort(m);
    }

    public int[][] diagonalSort(int[][] mat) {
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        int rows = mat.length;
        int cols = mat[0].length;

        for (int i=rows-1;i>0;i--) {
            queue.add(new Pair<>(i,0));
        }

        for (int i=0;i<cols;i++) {
            queue.add(new Pair<>(0,i));
        }
        while (!queue.isEmpty()) {
            Pair<Integer,Integer> pair = queue.poll();
            int x = pair.getKey();
            int y = pair.getValue();
            List<Integer> list = new ArrayList<>();
            while (x<rows&&y<cols) {
                list.add(mat[x++][y++]);
            }
            Collections.sort(list);
            x = pair.getKey();
            y = pair.getValue();
            int index = 0;
            while (x<rows&&y<cols) {
                mat[x++][y++] = list.get(index++);
            }
        }
        return mat;
    }
}
