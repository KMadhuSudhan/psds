package com.madhu.psds.arrays;
//https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
//873. Length of Longest Fibonacci Subsequence

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestFibonacciSubsequence {

    public static void main(String[] args) {
        LengthOfLongestFibonacciSubsequence lengthOfLongestFibonacciSubsequence = new LengthOfLongestFibonacciSubsequence();
        int[] nums = {1,2,3,4,5,6,7,8};
        lengthOfLongestFibonacciSubsequence.lenLongestFibSubseq(nums);
    }

    public int lenLongestFibSubseq(int[] A) {
        int n = A.length;
        Set<Integer> S = new HashSet<>();
        for (int t : A) {
            // Add each element into the set
            S.add(t);
        }
        int maxLen = 0, x, y;

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {

                x = A[j];
                y = A[i] + A[j];
                int length = 2;

                // check until next fib element is found
                while (S.contains(y)) {

                    // next element of fib subseq
                    int z = x + y;
                    x = y;
                    y = z;
                    ++length;
                }
                maxLen = Math.max(maxLen,length);
            }
        }
        return maxLen >= 3 ? maxLen : 0;
    }
}
