package com.madhu.psds.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = new int[] {10, 80, 30, 90, 40, 50, 70};
        int length = a.length;
        QuickSort quickSort = new QuickSort();
        quickSort.sort(a,0,length-1);
        quickSort.printSortedArray(a,length);
    }

    public void sort(int[] array,int lb,int ub) {
      if(lb < ub) {
          int partition = partition(array,lb,ub);
          sort(array,lb,partition-1);
          sort(array,partition+1,ub);
      }
    }

    public int partition(int[] array,int lb,int ub) {
        int pivot = lb;
        int start = lb;
        int end = ub;
        while (start < end ) {
            while (array[start] < array[pivot]){
                start++;
            }
            while (array[end] > array[pivot]){
                end--;
            }
            if(start < end) {
                int temp = array[end];
                array[end] = array[pivot];
                array[pivot] = temp;
            }
        }
        return end;
    }

    public  void printSortedArray(int[] array,int length) {
        for(int i=0;i<length;i++) {
            System.out.print(" " + array[i]);
        }
    }
}
