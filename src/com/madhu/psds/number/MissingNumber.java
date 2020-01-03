package com.madhu.psds.number;

public class MissingNumber {
    public static void main() {
        int[] numbers = new int[]{3, 0, 1};
        MissingNumber missingNumber = new MissingNumber();
        missingNumber.missingNumber(numbers);
    }

    public int missingNumber(int[] nums) {
        int arraySum = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            arraySum += nums[i];
        }
        int totalSum = (length * (length + 1)) / 2;
        return totalSum - arraySum;
    }
}
