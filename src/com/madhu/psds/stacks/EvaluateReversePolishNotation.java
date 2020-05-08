package com.madhu.psds.stacks;

import java.util.Stack;

//https://leetcode.com/problems/evaluate-reverse-polish-notation/
//150. Evaluate Reverse Polish Notation
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {
                "4","13","5","/","+"
        };
        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        System.out.println(evaluateReversePolishNotation.evalRPN(tokens));
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<tokens.length;i++) {
            if(isOperator(tokens[i])) {
                int res = eval(stack.pop(),stack.pop(),tokens[i].charAt(0));
                stack.push(res);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }

    int eval(int n2,int n1 ,char operator) {
        if(operator == '/') {
            return n1/n2;
        } else if(operator == '*') {
            return n1 * n2;
        } else if(operator == '-') {
            return n1-n2;
        }
        return n1+n2;
    }

    boolean isOperator(String s) {
        char symbol = s.charAt(0);
        return s.length() ==1 && (symbol == '-' || symbol == '+' || symbol == '*' || symbol == '/');
    }
}
