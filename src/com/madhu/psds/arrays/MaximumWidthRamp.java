package com.madhu.psds.arrays;
//https://leetcode.com/problems/maximum-width-ramp/
//962. Maximum Width Ramp
import java.util.Stack;

public class MaximumWidthRamp {
    public static void main(String[] args) {
        MaximumWidthRamp maximumWidthRamp = new MaximumWidthRamp();
        int[] nums = {6,0,8,2,1,5};
        maximumWidthRamp.maxWidthRamp(nums);
    }
    public int maxWidthRamp(int[] A) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < A.length; i++){
            if (A[stack.peek()] > A[i]){
                stack.push(i);
            }
        }
        int max = 0;
        int j = A.length - 1;
        while(j > max) {
            if (A[j] >= A[stack.peek()]){
                max = Math.max(max, j - stack.pop());
            } else{
                j--;
            }
        }
        return max;
    }
}
