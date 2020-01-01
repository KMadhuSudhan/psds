package com.madhu.psds.arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 0, 3, 12};
        int length = a.length;
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(a);
        moveZeroes.printArray(a, length);
    }

    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int i = 0;
        int k = 0;
        while (i < length && k < length) {
            if(nums[i]!=0){
                i++;
                k = i;
            } else {
                while (k < length && nums[k] == 0) {
                    k++;
                }
                if(k < length) {
                    int temp = nums[k];
                    nums[k] = nums[i];
                    nums[i] = temp;
                }
            }

        }
    }

    public void printArray(int[] array, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(" " + array[i]);
        }
    }
}
