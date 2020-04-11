package com.madhu.psds.practice;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        MoveZerosToEnd moveZerosToEnd = new MoveZerosToEnd();
        moveZerosToEnd.moveZeroes(nums);
        moveZerosToEnd.print(nums);
    }
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int i= 0;
        int j= 0;
        int[] result = new int[nums.length];
        while (i<length) {
               if(nums[i]!=0) {
                   nums[j] = nums[i];
                   j++;
               }
               i++;
        }
        while (j<length) {
            nums[j] = 0;
            j++;
        }
    }
    void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    void print(int[] nums) {
        for (int num: nums) {
            System.out.print(num + " ");
        }
    }
}
