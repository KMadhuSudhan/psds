package com.madhu.psds.stacks;
//https://leetcode.com/problems/basic-calculator-ii/
//227. Basic Calculator II

import java.util.Stack;

public class BasciCalculatorii {
    public static void main(String[] args) {
        BasciCalculatorii basciCalculatorii = new BasciCalculatorii();
        String str = "3+2*2";
        basciCalculatorii.calculate(str);
    }
    public int calculate(String s) {
        int answer = 0,num=0;
        char op = '+';
        s+=op;
        char[] sChars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<sChars.length;i++) {
            if(sChars[i] >= '0' && sChars[i] <= '9') {
                num = num *10 + sChars[i] - '0';
                continue;
            }
            if(sChars[i] == ' ') continue;
            switch (op) {
                case '+':
                    stack.push(num);
                    break;
                case '-':
                    stack.push(-num);
                    break;
                case '*':
                    stack.push(stack.pop()*num);
                    break;
                case '/':
                    stack.push(stack.pop()/num);
                    break;
            }
            op = sChars[i];
            num = 0;
        }
        while (!stack.isEmpty()) {
            answer+=stack.pop();
        }
        return answer;
    }
}
