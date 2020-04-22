package com.madhu.psds.arrays;
//https://leetcode.com/problems/prison-cells-after-n-days/
//957. Prison Cells After N Days

public class PrisonCellAfterNdays {
    public static void main(String[] args) {
        int[] cell = {0,1,0,1,1,0,0,1};
        int N = 7;
        PrisonCellAfterNdays prisonCellAfterNdays = new PrisonCellAfterNdays();
        prisonCellAfterNdays.prisonAfterNDays(cell,N);
    }
    public int[] prisonAfterNDays(int[] cells, int N) {
        int length = cells.length;
        for (int day=0;day<N;day++) {
            int[] temp = cells.clone();
            temp[0] = 0^temp[1];
            temp[length-1] = 0^temp[length-2];
            for (int i=1;i<length-1;i++) {
                temp[i] = temp[i-1] ^ temp[i+1];
            }
            cells = temp.clone();
        }
        return cells;
    }
}
