package com.madhu.psds.sort;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[]{10, 80, 30, 90, 40, 50, 70};
        int length = array.length;
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(array, length);
        insertionSort.printSortedArray(array,length);
    }

    public void sort(int[] array, int length) {
        int i,j;
        for(i=1;i<length;i++){
            int temp = array[i];
            j = i-1;
            while (j>=0 && array[j] > temp) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = temp;
        }
    }

    public void printSortedArray(int[] array, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(" " + array[i]);
        }
    }
}
