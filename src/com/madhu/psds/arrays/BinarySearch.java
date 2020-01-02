package com.madhu.psds.arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(nums, 9));
    }

    public int search(int[] nums, int target) {
        int length = nums.length;
        int low = 0;
        int high = length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}