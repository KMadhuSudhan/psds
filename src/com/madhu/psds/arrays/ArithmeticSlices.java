package com.madhu.psds.arrays;
//https://leetcode.com/problems/arithmetic-slices/submissions/
//413. Arithmetic Slices

public class ArithmeticSlices {
    int sum = 0;
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ArithmeticSlices arithmeticSlices = new ArithmeticSlices();
        arithmeticSlices.numberOfArithmeticSlices(nums);
    }
    public int numberOfArithmeticSlices(int[] A) {
        slices(A, A.length - 1);
        return sum;
    }
    public int slices(int[] A, int i) {
        if (i < 2)
            return 0;
        int ap = 0;
        if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
            ap = 1 + slices(A, i - 1);
            sum += ap;
        } else
            slices(A, i - 1);
        return ap;
    }
}
