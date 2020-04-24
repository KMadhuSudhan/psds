package com.madhu.psds.arrays;
//https://leetcode.com/problems/max-chunks-to-make-sorted/
//769. Max Chunks To Make Sorted

public class MaxChunksToMakeSorted {
    public static void main(String[] args) {
        MaxChunksToMakeSorted maxChunksToMakeSorted = new MaxChunksToMakeSorted();
        int[] arr = {4,3,2,1,0};
        maxChunksToMakeSorted.maxChunksToSorted(arr);
    }
    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++) {
            max = Math.max(max,arr[i]);
            if(max == i) count++;
        }
        return count;
    }
}
