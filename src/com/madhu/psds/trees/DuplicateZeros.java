package com.madhu.psds.trees;

public class DuplicateZeros {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        DuplicateZeros duplicateZeros = new DuplicateZeros();
        duplicateZeros.duplicateZeros(nums);
        duplicateZeros.printArray(nums);
    }

    public void duplicateZeros(int[] arr) {
        int length = arr.length;
        int i=0;
        while(i<length) {
            if(arr[i] == 0){
                int j = length -1;
                while(j>(i+1)) {
                    arr[j] = arr[j-1];
                    j--;
                }
                arr[j] = 0;
                i++;
            }
            i++;
        }
    }

    public void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
