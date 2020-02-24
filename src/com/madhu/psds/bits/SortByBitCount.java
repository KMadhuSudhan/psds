package com.madhu.psds.bits;
//https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
//1356. Sort Integers by The Number of 1 Bits

import java.util.Arrays;
import java.util.Comparator;

public class SortByBitCount {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        SortByBitCount sortByBitCount = new SortByBitCount();
        sortByBitCount.sortByBits(nums);
    }

    public int[] sortByBits(int[] arr) {
        int length = arr.length;
        Integer[] input = new Integer[length];
        for (int i = 0; i < length; i++) {
            input[i] = arr[i];
        }
        Comparator<Integer> bitComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Integer.bitCount(o1) == Integer.bitCount(o2)) {
                    return o1 - o2;
                } else {
                    return Integer.bitCount(o1) - Integer.bitCount(o2);
                }
            }
        };
        Arrays.sort(input, bitComparator);
        for (int i = 0; i < length; i++) {
            arr[i] = input[i];
        }
        return arr;
    }
}
