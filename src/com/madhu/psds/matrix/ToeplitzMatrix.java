package com.madhu.psds.matrix;

public class ToeplitzMatrix {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {23,40,65,20,51,7,18,74,18,0,35,31},
                {86,23,40,65,20,51,7,18,74,18,13,35},
                {53,86,23,40,65,20,51,7,18,74,18,13},
                {72,53,86,23,40,65,20,51,7,18,74,18},
                {73,72,53,86,23,40,65,20,51,7,18,74},
                {62,73,72,53,86,23,40,65,20,51,7,18}
        };
        ToeplitzMatrix toeplitzMatrix = new ToeplitzMatrix();
        System.out.print(toeplitzMatrix.isToeplitzMatrix(nums));
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        int columns = matrix[0].length;
        int rows = matrix.length;
        boolean isToeplitz = true;
        int i =1;
        int j = columns -1;

        //right diagonal
        while (i< (rows -1)) {
            int diagonalXStart = i;
            int diagonalYStart = j;
            int x = matrix[diagonalXStart][diagonalYStart];

            while (diagonalXStart >= 0 && diagonalYStart >= 0) {
                System.out.println(" x,y=>" + diagonalXStart + " ," + diagonalYStart);
                if (x != matrix[diagonalXStart][diagonalYStart]) {
                    return false;
                }
                diagonalXStart--;
                diagonalYStart--;
            }
            i++;
        }

        i = rows-1;
        j = columns -1;

        //left diagonal
        while (j<= 1) {
            int diagonalXStart = i;
            int diagonalYStart = j;
            int x = matrix[diagonalXStart][diagonalYStart];
            while (diagonalXStart != 0 && diagonalYStart != 0) {
                if (x != matrix[diagonalXStart][diagonalYStart]) {
                    return false;
                }
                diagonalXStart--;
                diagonalYStart--;
            }
            j--;
        }
        return isToeplitz;

    }
}

