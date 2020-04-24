package com.madhu.psds.arrays;
//https://leetcode.com/problems/max-chunks-to-make-sorted-ii/
//768. Max Chunks To Make Sorted II

public class MaxChunksToMakeSortedII {
    public static void main(String[] args) {
        MaxChunksToMakeSortedII maxChunksToMakeSortedII = new MaxChunksToMakeSortedII();
        int[] array = {2, 1, 3, 4, 4};
        maxChunksToMakeSortedII.maxChunksToSorted(array);
    }

    public int maxChunksToSorted(int[] arr) {
        int[] max = new int[arr.length];
        int[] min = new int[arr.length];
        max[0] = arr[0];
        min[arr.length - 1] = arr[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            max[i] = Math.max(max[i - 1], arr[i]);
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            min[i] = Math.min(min[i + 1], arr[i]);
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1 && max[i] <= min[i + 1]) {
                count++;
            }
        }
        return ++count;
    }
}
