package com.madhu.psds.sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{10, 80, 30, 90, 40, 50, 70};
        int length = array.length;
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array, 0, length-1);
        mergeSort.printSortedArray(array, length);
    }

    public void sort(int[] array, int lb, int ub) {
        if (lb < ub) {
            int mid = (lb + ub) / 2;
            sort(array, lb, mid);
            sort(array, mid + 1, ub);
            merge(array, lb, mid, ub);
        }
    }

    public void merge(int[] array, int lb, int mid, int ub) {
        int n1 = mid - lb + 1;
        int n2 = ub - mid;
        int i, j, k;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (i = 0; i < n1; i++) {
            L[i] = array[lb + i];
        }
        for (j = 0; j < n2; j++) {
            R[j] = array[mid + 1 + j];
        }
        i = 0;
        j = 0;
        k = lb;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    public void printSortedArray(int[] array, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(" " + array[i]);
        }
    }
}
