package com.madhu.psds.arrays;

public class ReplaceElementsWithGreatest {
    public static void main(String[] args) {
        int[] arr = new int[]{17, 18, 5, 4, 6, 1};
        ReplaceElementsWithGreatest replaceElementswithGreatest = new ReplaceElementsWithGreatest();
        replaceElementswithGreatest.replaceElements(arr);
        replaceElementswithGreatest.printArray(arr);
    }

    public int[] replaceElements(int[] arr) {
        int prev;
        int length = arr.length;
        if(length == 1) {
            arr[0] = -1;
            return arr;
        }
        int max = arr[length - 1];
        int j = length - 2;
        while (j >= 0) {
            prev = arr[j];
            arr[j] = max;
            max = Math.max(prev, max);
            j--;
        }
        arr[length - 1] = -1;
        return arr;
    }

    public void printArray(int[] array) {
        for (int element : array) {
            System.out.print(" " + element);
        }
    }
}
