package com.madhu.psds.arrays;

import java.util.Stack;

public class LargestRectangleHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        LargestRectangleHistogram largestRectangleHistogram = new LargestRectangleHistogram();
//        largestRectangleHistogram.largestRectangleAreaBruteForce(heights);
        System.out.println(largestRectangleHistogram.largestRectangleAreaUsingStack(heights));
    }

    public int largestRectangleAreaUsingStack(int[] heights) {
        int i;
        Stack<Integer> stack = new Stack<>();
        int length = heights.length;
        if (length == 0) return 0;
        int maxArea = heights[0] * 1;
        int area;
        for (i = 0; i < length;) {
            if (stack.empty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                //if stack is empty means everything till i has to be
                //greater or equal to input[top] so get area by
                //input[top] * i;
                if(stack.isEmpty()){
                    area = heights[top] * i;
                }
                //if stack is not empty then everythin from i-1 to input.peek() + 1
                //has to be greater or equal to input[top]
                //so area = input[top]*(i - stack.peek() - 1);
                else{
                    area = heights[top] * (i - stack.peek() - 1);
                }
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }


    public int largestRectangleAreaBruteForce(int[] heights) {
        int i, j;
        int length = heights.length;
        if (length == 0) return 0;
        int maxArea = heights[0] * 1;
        for (i = 0; i < length; i++) {
            int minHeight = heights[i];
            for (j = i; j < length; j++) {
                minHeight = Math.min(heights[j], minHeight);
                int width = j - i + 1;
                maxArea = Math.max(width * minHeight, maxArea);
            }
        }
        return maxArea;
    }
}

