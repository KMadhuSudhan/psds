package com.madhu.psds.matrix;
//https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
//1337. The K Weakest Rows in a Matrix

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KweakestRows {
    class WeakestRow {
        int row;
        int soldiers;
        int civilians;
        WeakestRow(int row,int soldiers,int civilians) {
            this.row = row;
            this.soldiers = soldiers;
            this.civilians = civilians;
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        KweakestRows kweakestRows = new KweakestRows();
        kweakestRows.kWeakestRows(mat,3);
    }
    List<WeakestRow> getAll(int[][] mat,int rows,int columns) {
        int i,j;
        List<WeakestRow> weakestRows = new ArrayList<>();
        for(i=0;i<rows;i++) {
            int soldiers = 0;
            int civilians = 0;
            for (j=0;j<columns;j++) {
                if(mat[i][j] == 0) {
                    civilians++;
                } else {
                    soldiers++;
                }
            }
            WeakestRow weakestRow = new WeakestRow(i,soldiers,civilians);
            weakestRows.add(weakestRow);
        }
        return weakestRows;
    }

    List<WeakestRow> sortByWeak(List<WeakestRow> weakestRows) {
        Comparator<WeakestRow> weakestRowComparator = new Comparator<WeakestRow>() {
            @Override
            public int compare(WeakestRow o1, WeakestRow o2) {
                return o1.soldiers - o2.soldiers;
            }
        };
        Collections.sort(weakestRows,weakestRowComparator);
        return weakestRows;
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int i;
        int rows = mat.length;
        int columns = mat[0].length;
        List<WeakestRow> weakestRows = getAll(mat,rows,columns);
        weakestRows = sortByWeak(weakestRows);
        int[] weakestKRows = new int[k];
        i =0;
        for(WeakestRow weakestRow: weakestRows) {
            if(k == i) break;
            weakestKRows[i] = weakestRow.row;
            i++;
        }
        return weakestKRows;
    }
}
