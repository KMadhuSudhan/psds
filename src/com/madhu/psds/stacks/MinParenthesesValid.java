package com.madhu.psds.stacks;

import java.util.Stack;

public class MinParenthesesValid {

    public int minAddToMakeValid(String S) {
        char[] arr = S.toCharArray();
        int length = arr.length;
        int open = 0;
        Stack<Character> stack = new Stack();
        for(int i=0;i<length;i++) {
            if(arr[i] == '(') {
                stack.push('(');
            } else {
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }  else {
                    stack.push(')');
                }
            }
        }
        return  stack.size();
    }

    public int withoutStack(String S) {
        int leftCount = 0;
        int count = 0;

        for(int i=0;i<S.length();i++) {
            switch (S.charAt(i)) {
                case '(':
                    leftCount++;
                    break;
                case ')':
                    if(leftCount == 0) {
                        count++;
                    } else {
                        leftCount--;
                    }
                    break;
                default:
                    continue;
            }
        }

        count += leftCount;
        return count;
    }
}
