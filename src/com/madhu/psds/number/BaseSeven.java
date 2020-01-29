package com.madhu.psds.number;

import java.util.Stack;

public class BaseSeven {
    public static void main(String[] args) {
        BaseSeven baseSeven = new BaseSeven();
        System.out.println(baseSeven.convertToBase7(100));
    }

    public String convertToBase7(int num) {
        String base7 = "";
        Stack<Integer> stack = new Stack<>();
        while (num > 0) {
            int r = num % 7;
            stack.push(r);
            num = num/7;
        }
        while (!stack.empty()) {
            base7 += stack.pop();
        }
        return base7;
    }
}
