package com.madhu.psds.matrix;
//https://leetcode.com/problems/diagonal-traverse/
//498. Diagonal Traverse


public class DiagonalTraverse {
    public static void main(String[] args) {
        DiagonalTraverse diagonalTraverse = new DiagonalTraverse();
        int[][] matrix = {
                {2,3},
        };
        System.out.println(diagonalTraverse.findDiagonalOrder(matrix));
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        // one simple case
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int M=matrix.length,N=matrix[0].length;
        //the length of result array
        int length=M*N;
        // the array I will return
        int[] result = new int [length];

        //my idea is :
        //to image  a small block moving,our task is to simulate the real path of it.
        //I use(i,j) to indicates its current location.
        int i=0,j=0;
        //count is the data already been processed
        int count=0;
        result[0]=matrix[0][0];
        //The direction of movement of the small block, clockwise
        while(count<length-1){
            //Take a step to the right，or go down if it can't move to right(out of index)
            if(j+1<N) result[++count]=matrix[i][++j];
            else {
                if(i+1<M) result[++count]=matrix[++i][j];
            }
            //Keep walking down left until it can't move
            while(i+1<M&&j-1>=0){ result[++count]=matrix[++i][--j];}
            //Take a step down，or go right if it can't move to down(out of index)
            if(i+1<M) result[++count]=matrix[++i][j];
            else {
                if(j+1<N)
                    result[++count]=matrix[i][++j];
            }
            //Keep walking up right until it can't move
            while(i-1>=0&&j+1<N) { result[++count]=matrix[--i][++j];}
        }
        return result;
    }

    void reverse(int[] nums,int low,int high) {
        while (low<high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
        }
    }
}
