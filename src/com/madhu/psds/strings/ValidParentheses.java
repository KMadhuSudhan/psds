package com.madhu.psds.strings;
//https://leetcode.com/problems/valid-parentheses/
//20. Valid Parentheses

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String str = "{[]}";
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid(str));
    }
    public boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        int length = s.length();
        char[] chars = s.toCharArray();

        for(int i=0;i<length;i++) {
            if(!characterStack.isEmpty() && ((chars[i] == '}' && characterStack.peek() == '{')
                    || (chars[i] == ']' && characterStack.peek() == '[')
                    || (chars[i] == ')' && characterStack.peek() == '('))) {
                characterStack.pop();
            } else {
                characterStack.push(chars[i]);
            }
        }
        return characterStack.isEmpty();
    }
}
