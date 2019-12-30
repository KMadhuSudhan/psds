package com.madhu.psds.sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[]{10, 80, 30, 90, 40, 50, 70};
        int length = array.length;
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(array, length);
        selectionSort.printSortedArray(array,length);
    }

    public void sort(int[] array, int length) {
        int i, j;
        for (i = 0; i < length - 1; i++) {
            int min = i;
            for (j = i+1; j < length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if(i!=min) {
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
        }
    }

    public void printSortedArray(int[] array, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(" " + array[i]);
        }
    }

}
