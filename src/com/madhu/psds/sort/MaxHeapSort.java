package com.madhu.psds.sort;

public class MaxHeapSort {

    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[largest] < arr[right])
            largest = right;
        if (right < n && arr[largest] < arr[left])
            largest = left;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    private void buildHeap(int[] arr, int n) {
        int startIndex = n / 2 - 1;
        for (int i = startIndex; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    private void printHeap(int[] arr, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 4, 6, 13, 10,
                9, 8, 15, 17};
        int n = arr.length;
        MaxHeapSort maxHeapSort = new MaxHeapSort();
        maxHeapSort.buildHeap(arr, n);
        maxHeapSort.printHeap(arr, n);
    }
}
