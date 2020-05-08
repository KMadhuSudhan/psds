package com.madhu.psds.arrays;

import java.util.Stack;
//https://leetcode.com/problems/daily-temperatures/submissions/
//739. Daily Temperatures

public class DailyTemparature {
    public static void  main(String[] args) {
        DailyTemparature dailyTemparature = new DailyTemparature();
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        dailyTemparature.dailyTemperatures(nums);
    }
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int size = T.length;
        int [] result = new int[size];
        result[size-1]=0; /* last elment will not have any warmer day */
        stack.add(size-1);

        if(size==1)
            return new int[]{0};

        for(int i=size-2;i>=0;i--){
            while(!stack.isEmpty() && T[stack.peek()]<=T[i] )
                stack.pop();
            if(stack.isEmpty())
                result[i]=0;
            else
                result[i]= stack.peek()-i;
            stack.push(i);
        }
        return result;
    }
}
