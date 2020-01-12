package com.madhu.psds.arrays;

import java.util.Stack;

public class BaseBallGame {
    public static void main(String[] args) {
        String[] ops = new String[]{"5", "2", "C", "D", "+"};
        BaseBallGame baseBallGame = new BaseBallGame();
        System.out.println(baseBallGame.calPoints(ops));
    }

    public int calPoints(String[] ops) {
        int[] arr = new int[ops.length];
        int sum = 0,top = -1 ;
        for(String s : ops) {
            if (s.equals("+")) {
                int score = arr[top] + arr[top-1];
                arr[++top] = score;
                sum += score;
            } else if (s.equals("D")) {
                int pop = arr[top];
                int doubleValue = pop * 2;
                arr[++top] = doubleValue;
                sum += doubleValue;
            } else if (s.equals("C")) {
                int popped =  arr[top--];
                sum -= popped;
            } else {
                int val = Integer.valueOf(s);
                arr[++top] = val;
                sum += val;
            }
        }
        return sum;
    }
}
