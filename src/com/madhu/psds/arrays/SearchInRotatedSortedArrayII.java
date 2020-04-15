package com.madhu.psds.arrays;
//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
//81. Search in Rotated Sorted Array II

public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        SearchInRotatedSortedArrayII searchInRotatedSortedArrayII = new SearchInRotatedSortedArrayII();
        searchInRotatedSortedArrayII.search(nums,0);
    }

    public boolean search(int[] arr, int target) {
        int n = arr.length;
        int low = 0, high = n - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == target || arr[low] == target || arr[high] == target) return true;
            if (arr[mid] > arr[high]) {   //left side is sorted we can compare target directly
                if (arr[low] < target && arr[mid] > target) high = mid - 1;
                else low = mid + 1;
            } else if (arr[mid] < arr[high]) {   //right side is sorted
                if (arr[mid] < target && arr[high] > target)
                    low = mid + 1;
                else high = mid - 1;
            } else {
                high--;      //it can be low++ or high--. It means if both side are not sorted then either ignoer left or right and check according in remianing series. We ignore because we know neither left element or right element is equal to target.
            }
        }
        return false;
    }
}
