package com.madhu.psds.number;

public class SumOfEvenNumbers {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4};
        int[][] queries = new int[][]{
                {1, 0},
                {-3, 1},
                {-4, 0},
                {2, 3}
        };
        SumOfEvenNumbers sumOfEvenNumbers = new SumOfEvenNumbers();
        sumOfEvenNumbers.sumEvenAfterQueries(A, queries);
    }

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int queriesLength = queries.length;
        int[] result = new int[queriesLength];
        int evenSum = 0;
        for (int num : A) {
            if (num % 2 == 0) {
                evenSum += num;
            }
        }
        int j = 0;
        for (int i = 0; i < queriesLength; i++) {
            int addValue = queries[i][0];
            int addIndex = queries[i][1];
            int resultValue = 0;
            if (A[addIndex] % 2 != 0) {
                resultValue = A[addIndex] + addValue;
                if (resultValue % 2 == 0) {
                    evenSum += resultValue;
                }

            } else {
                resultValue = A[addIndex] + addValue;
                if (resultValue % 2 == 0) {
                    evenSum -= A[addIndex];
                    evenSum += resultValue;
                } else {
                    evenSum -= A[addIndex];
                }
            }
            A[addIndex] = resultValue;
            result[j] = evenSum;
            j++;
        }
        return result;
    }
}
