package com.madhu.psds.strings;
//https://leetcode.com/problems/longest-valid-parentheses/
//32. Longest Valid Parentheses

import java.util.Arrays;
import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        String str = ")()())";
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        System.out.println(longestValidParentheses.longestValidParentheses(str));
    }

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int length = s.length();
        char[] chars = s.toCharArray();
        boolean[] check = new boolean[s.length()];

        for (int i = 0; i < length; i++) {
            if (!stack.isEmpty() && chars[i] == ')') {
                int index = stack.pop();
                check[index] = true;
                check[i] = true;
            } else if(chars[i] == '(') {
                stack.push(i);
            }
        }
        int longest = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (check[i]) count++;
            else {
                longest = Math.max(count, longest);
                count = 0;
            }
        }
        longest = Math.max(count, longest);
        return longest;
    }

    public int longestValidParentheses1(String s) {
        int res = searchFromLeftToRight(s);
        int res2 = searchFromRightToLeft(s);
        return Math.max(res, res2);
    }

    // (() <-
    private int searchFromRightToLeft(String s) {
        int open = 0, close = 0, res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')')
                close++;
            else {
                open++;
                if (close == open)
                    res = Math.max(res, 2 * close);
                if (open > close) {
                    open = close = 0;
                }
            }
        }
        return res;
    }

    // -> (()
    private int searchFromLeftToRight(String s) {
        int open = 0, close = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                open++;
            else {
                close++;
                if (open == close)
                    res = Math.max(res, 2 * open);
                if (close > open) {
                    close = open = 0;
                }
            }
        }
        return res;
    }
}
