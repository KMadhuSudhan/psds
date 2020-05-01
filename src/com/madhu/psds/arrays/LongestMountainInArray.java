package com.madhu.psds.arrays;
//https://leetcode.com/problems/longest-mountain-in-array/
//845. Longest Mountain in Array

public class LongestMountainInArray {
    public static void main(String[] args) {
        int[] nums = {2,1,4,7,3,2,5};
        LongestMountainInArray longestMountainInArray = new LongestMountainInArray();
        System.out.println(longestMountainInArray.longestMountain(nums));
    }
    public int longestMountain(int[] A) {
        int length = A.length,i=0,maxSize=0,size;
        while (i<length) {
            int asc = 0;
            int j = i;
            while (i+1 < length && A[i] < A[i+1]) {
                i++;
                asc++;
            }
            int dsc = 0;
            while (i+1 < length && A[i] > A[i+1]) {
                i++;
                dsc++;
            }
            if(j == i) i++;
            if(dsc > 0 && asc > 0) {
                maxSize = Math.max(maxSize,dsc + asc + 1);
            }
        }
        return maxSize;
    }
}
