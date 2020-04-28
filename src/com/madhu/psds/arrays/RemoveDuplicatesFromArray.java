package com.madhu.psds.arrays;
//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
//80. Remove Duplicates from Sorted Array II

public class RemoveDuplicatesFromArray {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,3};
        RemoveDuplicatesFromArray removeDuplicatesFromArray = new RemoveDuplicatesFromArray();
        removeDuplicatesFromArray.removeDuplicates(nums);
    }

    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0,count=0, length = nums.length;
        while (j < length) {
            while ( j < length && nums[j] == nums[i]) j++;
            if ((j - i) > 2) {
                int low = i+2;
                int high = j;
                while (high < length) {
                    nums[low++] = nums[high++];
                }
                length = length + 2 - (j-i);
                count += 2;
                j=i+2;
                i=j;
            } else {
                count += j - i;
                i=j;
            }
        }
        return count;
    }
}
