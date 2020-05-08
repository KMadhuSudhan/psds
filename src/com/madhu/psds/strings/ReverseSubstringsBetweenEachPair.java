package com.madhu.psds.strings;
//https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
//1190. Reverse Substrings Between Each Pair of Parentheses

import java.util.Stack;

public class ReverseSubstringsBetweenEachPair {
    public static void main(String[] args) {
        String s = "(abcd)";
        ReverseSubstringsBetweenEachPair reverseSubstringsBetweenEachPair = new ReverseSubstringsBetweenEachPair();
        System.out.println(reverseSubstringsBetweenEachPair.reverseParentheses(s));
    }

    public String reverseParentheses(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ')') {
                stack.push(chars[i]);
                continue;
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty() && stack.peek() != '(') {
                sb.append(stack.pop());
            }
            //remove '('
            if (!stack.isEmpty()) {
                stack.pop();
                copyChars(sb.toString(), stack);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }

    void copyChars(String s, Stack<Character> stack) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            stack.push(chars[i]);
        }
    }
}
