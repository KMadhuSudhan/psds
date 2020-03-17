package com.madhu.psds.arrays;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        NextGreaterElementII nextGreaterElementII = new NextGreaterElementII();
        int[] result = nextGreaterElementII.nextGreaterElements(nums);
        nextGreaterElementII.print(result);
    }

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int length = nums.length;
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < length * 2; i++) {
            while (!stack.isEmpty() && nums[i%length] >  nums[stack.peek()]) {
                int index = stack.pop();
                result[index] = nums[i%length];
            }
            if(i< nums.length) {
                stack.push(i);
            }
        }
        return result;
    }

    public void print(int[] nums) {
        for (int num : nums) {
            System.out.println(num + " ");
        }
    }
}
