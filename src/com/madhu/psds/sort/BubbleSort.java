package com.madhu.psds.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[]{10, 80, 30, 90, 40, 50, 70};
        int length = array.length;
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array, length);
        bubbleSort.printSortedArray(array, length);
    }

    public void sort(int[] array, int length) {
        int i, j;
        for (i = 0; i < length - 1; i++) {
            int flag = 0;
            for (j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    flag = 1;
                }
            }
            if (flag == 0) break;
        }
    }

    public void printSortedArray(int[] array, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(" " + array[i]);
        }
    }
}
