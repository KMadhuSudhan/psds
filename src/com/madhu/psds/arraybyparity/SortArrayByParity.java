package com.madhu.psds.arraybyparity;

public class SortArrayByParity {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,2,4};
       sortArrayByParity(arr);
       for(int i =0;i<arr.length;i++) {
           System.out.print(arr[i] + " ");
       }
    }
    private static int[] sortArrayByParity(int[] A) {
        int length = A.length;
        int i =0,j = length -1;
        while(i<j) {
            while(i < j && A[i]%2 == 0) {
                i++;
            }
            while(i < j && A[j]%2 == 1) {
                j--;
            }
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
        return A;
    }
}
