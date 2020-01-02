package com.madhu.psds.arrays;

public class UnsortedSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
        UnsortedSubarray unsortedSubarray = new UnsortedSubarray();
        System.out.println(unsortedSubarray.findUnsortedSubarray(nums));
    }

    public int findUnsortedSubarray(int[] nums) {
        int endPos = -1;
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (temp > nums[i])
                endPos = i;
            else
                temp = nums[i];
        }

        if (endPos == -1)
            return 0;

        int startPos = -1;
        temp = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {

            if (temp < nums[i])
                startPos = i;
            else
                temp = nums[i];

        }

        return (endPos - startPos) + 1;
    }
}