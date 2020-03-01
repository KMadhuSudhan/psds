package com.madhu.psds.arrays;
//https://leetcode.com/problems/sort-colors/
//75. Sort Colors

public class SortColors {
    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors.sortColors(nums);
        sortColors.print(nums);
    }

    public void sortColors(int[] nums) {
        int length = nums.length;
        int low = 0;
        int mid = 0;
        int hight = length - 1;
        while (mid <= hight) {
            switch (nums[mid]) {
                case 0:
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, hight, mid);
                    hight--;
                    break;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void print(int[] nums) {
        for (int i=0;i<nums.length;i++) {
            System.out.println(nums[i]);
        }
    }
}
