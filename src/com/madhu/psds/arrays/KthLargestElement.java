package com.madhu.psds.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {
    int kthMax;
    int bubbleSort(int nums[], int k) {
        int i, j;
        int n = nums.length;
        for (i = 0; i < k; i++) {
            for (j = 0; j < n - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums[n-k];
    }

    void kthMaxUsingQuickSort(int nums[],int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        int high = nums.length - 1;
        quickSort(nums, 0, high,k);
    }

    void quickSort(int nums[], int low, int high,int k) {
        if (low < high) {
            int pivot = partition(nums, low, high);
            if(high - k + 1 == pivot){
                kthMax = nums[pivot];
                return;
            }
            quickSort(nums, low, pivot - 1,k);
            quickSort(nums, pivot + 1, high,k);
        }
    }

    int partition(int nums[], int low, int high) {
        int pivot = nums[low];
        int start = low;
        int end = high;
        while (start < end) {
            while (nums[start] <= pivot) {
                start++;
            }
            while (nums[end] > pivot) {
                end--;
            }
            if (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
        int temp = nums[low];
        nums[low] = nums[end];
        nums[end] = temp;
        return end;
    }

    public static void main(String[] args) {
        KthLargestElement kthLargestElement = new KthLargestElement();
        int[] nums = {3, 2, 1, 5, 6, 4};
//        kthLargestElement.bubbleSort(nums, 2);
//        kthLargestElement.print(nums);
        kthLargestElement.kthMaxUsingQuickSort(nums,2);
        kthLargestElement.print(nums);
//        System.out.println(kthLargestElement.quickSort(nums,2));
    }

    private void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i] + " ");
        }
    }
}
