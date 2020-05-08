package com.madhu.psds.stacks;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        String s = "2-(5-6)";
        BasicCalculator basicCalculator = new BasicCalculator();
        System.out.println(basicCalculator.calculate(s));
    }

    public int calculate(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') continue;
            if (chars[i] != ')') {
                stack.push(chars[i]);
                continue;
            }
            StringBuilder sb = new StringBuilder();
            while (stack.peek() != '(') {
                sb.append(stack.pop());
            }
            // pop '('
            stack.pop();
            sb = sb.reverse();
            int answer = evalString(sb.toString());
            String evalStr = String.valueOf(answer);
            char[] evalChars = evalStr.toCharArray();
            int j;
            if (!stack.isEmpty() && stack.peek() == '-' && evalChars[0] == '-') {
                stack.pop();
                stack.push('+');
                j = 1;
            } else {
                j = 0;
            }
            while (j < evalChars.length) {
                stack.push(evalChars[j]);
                j++;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        int ans = evalString(sb.reverse().toString());
        return ans;
    }

    public int evalString(String s) {
        char op = '+';
        s += op;
        char[] chars = s.toCharArray();
        int num = 0, answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                num = num * 10 + chars[i] - '0';
                continue;
            }
            if (chars[i] == ' ') continue;
            switch (op) {
                case '+':
                    stack.push(num);
                    break;
                case '-':
                    stack.push(-num);
                    break;
                case '/':
                    stack.push(stack.pop() / num);
                    break;
                case '*':
                    stack.push(stack.pop() * num);
                    break;
            }
            op = chars[i];
            num = 0;
        }
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        return answer;
    }

}
