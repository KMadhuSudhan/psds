package com.madhu.psds.matrix;

public class PrintDiagonal {
    public void print(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row;
        int col;
        int col1;
        int row1;
        for(col = columns-1;col>=0;col--) {
            row = 0;
            col1 = col;
            while (row < rows && col1 < columns ) {
                System.out.println(matrix[row][col1]);
                row++;
                col1++;
            }
        }
        for(row = 1;row<rows;row++) {
            col1 = 0;
            row1 = row;
            while (row1 < rows && col1 < columns ) {
                System.out.println(matrix[row1][col1]);
                row1++;
                col1++;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrx = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        PrintDiagonal printDiagonal = new PrintDiagonal();
        printDiagonal.print(matrx);
    }
}
/*
1  2  3
4  5 6
7  8 9

1  2   3   4
5  6   7   8
9  10  11  12
13 14  15  16

5  6  7  8
9  10 11 12
13 14 15 16
*/