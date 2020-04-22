package com.madhu.psds.arrays;
//https://leetcode.com/problems/maximum-length-of-repeated-subarray/
//718. Maximum Length of Repeated Subarray

public class MaximumLengthofRepeatedSubarray {
    public static void main(String[] args) {
        int[] a = {1,2,3,2,1};
        int[] b = {3,2,1,4,7};
        MaximumLengthofRepeatedSubarray maximumLengthofRepeatedSubarray = new MaximumLengthofRepeatedSubarray();
        System.out.println(maximumLengthofRepeatedSubarray.findLength(a,b));
    }
    public int findLength(int[] A, int[] B) {
       int lengthA = A.length;
       int lengthB = B.length;
       int i=0;
       int j=0;
       int size = 0;
       int maxSize = 0;
       while (i<lengthA && j < lengthB) {
           while(i<lengthA && A[i] != B[j]) {
               i++;
           }
           while(j<lengthB && A[i] != B[j]) {
               i++;
           }

           while (i<lengthA && j < lengthB && A[i] == B[j]) {
                size++;
                i++;
                j++;
           }
           maxSize = Math.max(size,maxSize);
       }
       return maxSize;
    }
}
