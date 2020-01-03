package com.madhu.psds.arrays;

public class SmallestRange {
    public static void main(String[] args) {
        int[] A = new int[]{0, 10};
        int K = 2;
        SmallestRange smallestRange = new SmallestRange();
        System.out.println(smallestRange.smallestRangeI(A, K));
    }

    public int smallestRangeI(int[] A, int K) {
        if (A.length == 0) {
            System.out.println("array has no values");
            return K;
        }
        //was going to use Integer.MIN_VALUE; but just using 0 index is more easier
        //helps with base case for the forloop (when the array only has 1 value)
        int smallestNum = A[0];
        int largestNum = A[0];

        //finds which is the largest and smallest numbers
        for (int i = 0; i < A.length; i++) {
            if (A[i] > largestNum) {
                largestNum = A[i];
            } else if (A[i] < smallestNum) {
                smallestNum = A[i];
            }
        }
        if ((largestNum - K) - (smallestNum + K) <= 0) {
            return 0;
        }
        return (largestNum - K) - (smallestNum + K);
    }
}
