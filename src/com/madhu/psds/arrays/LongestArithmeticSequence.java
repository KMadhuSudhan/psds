package com.madhu.psds.arrays;

public class LongestArithmeticSequence {
    public static void main(String[] args) {
        int[] arr = {3, 6, 9, 12};
        LongestArithmeticSequence longestArithmeticSequence = new LongestArithmeticSequence();
        longestArithmeticSequence.longestArithSeqLength(arr);
    }

    public int longestArithSeqLength(int[] A) {
        int diff = A[1] - A[0];
        int length = A.length;
        int count = 0;
        int maxCountSoFar = 0;
        for (int i = 2; i < length; i++) {
            if (A[i] - A[i - 1] == diff) {
                count++;
            } else {
                diff = A[i] - A[i - 1];
            }
            if (maxCountSoFar < count) maxCountSoFar = count;
        }
        return maxCountSoFar;
    }
}
