package com.madhu.psds.arrays;

public class PlusOne {
    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] nums = {1, 2, 3};
    }

    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int[] result = new int[length+1];
        int sum;
        int carry = 1;
        for (int i = length - 1; i >= 0; i--) {
            sum = carry + digits[i];
            if (sum == 10) {
                result[i+1] = 0;
                carry = 1;
            } else if (sum > 10) {
                result[i+1] = sum - 10;
                carry = 1;
            } else {
                result[i+1] = sum;
                carry = 0;
            }
        }
        if(carry!=0) {
            result[0] = carry;
            return result;
        } else {
            for(int i =1;i<=length;i++) {
                digits[i-1] = result[i];
            }
            return digits;
        }
    }
}
