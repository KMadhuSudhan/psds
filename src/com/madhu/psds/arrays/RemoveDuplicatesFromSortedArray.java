package com.madhu.psds.arrays;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if(length == 0) return 0;
        int count = 1;
        int current = nums[0];
        int uniq = 1;
        for (int i=1;i<length;i++) {
            if(nums[i] == current) {
                continue;
            }
            current = nums[i];
            nums[uniq] = current;
            uniq++;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        removeDuplicatesFromSortedArray.removeDuplicates(nums);
    }
}
