package com.madhu.psds.arrays;

public class NumberOfSubArraysWithBoundedMax {
    public static void main(String[] args) {
        int[] A = {73,55,36,5,55,14,9,7,72,52};
        int L = 32;
        int R = 69;
        NumberOfSubArraysWithBoundedMax numberOfSubArraysWithBoundedMax = new NumberOfSubArraysWithBoundedMax();
        System.out.println(numberOfSubArraysWithBoundedMax.numSubarrayBoundedMax(A,L,R));
    }

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int len = A.length;
        int count = 0;
        int oi = len , li = len;
        for(int i =  A.length -1; i >= 0 ; i--){

            if(A[i] >= L && A[i] <= R) li = i;

            if(A[i] > R) oi = i;

            count += oi > li ? oi -li : 0;

        }
        return count;
    }
}
