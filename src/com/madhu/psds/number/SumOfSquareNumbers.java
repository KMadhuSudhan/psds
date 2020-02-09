package com.madhu.psds.number;
//https://leetcode.com/problems/sum-of-square-numbers/
//633. Sum of Square Numbers

public class SumOfSquareNumbers {
    public static void main(String[] args) {
        int n = 5;
        SumOfSquareNumbers sumOfSquareNumbers = new SumOfSquareNumbers();
        System.out.println(sumOfSquareNumbers.judgeSquareSum(n));
    }

    public boolean judgeSquareSum(int c) {
        int low = 0;
        int high = (int) Math.sqrt(c);
        while (low <= high) {
            final int sum = low * low + high * high;
            if (c == sum) {
                return true;
            } else if (sum < c) {
                low++;
            } else {
                high--;
            }
        }
        return false;
    }
}
