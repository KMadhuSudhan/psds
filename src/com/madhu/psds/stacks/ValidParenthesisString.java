package com.madhu.psds.stacks;
//https://leetcode.com/problems/valid-parenthesis-string/
//678. Valid Parenthesis String

public class ValidParenthesisString {
    public static void main(String[] args) {
        String str = "(*))";
        ValidParenthesisString validParenthesisString = new ValidParenthesisString();
        System.out.println(validParenthesisString.checkValidString(str));
    }

    public boolean checkValidString(String s) {
        int count = 0;

        for (char c: s.toCharArray()) {
            if (c == '(' || c == '*') count++;
            if (c == ')') count--;

            if (count < 0) return false;
        }

        if (count == 0) return true;
        count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')' || c == '*') count++;
            if (c == '(') count--;

            if (count < 0) return false;
        }

        return true;
    }
}
