package com.madhu.psds.strings;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/generate-parentheses/
//22. Generate Parentheses

public class GenerateParentheses {
    List<String> parentheses = new ArrayList<>();
    public static void main(String[] args) {
        int n =3;
        GenerateParentheses generateParentheses = new GenerateParentheses();
        generateParentheses.generateParenthesis(n);
        generateParentheses.print();
    }

    public List<String> generateParenthesis(int n) {
        char[] str = new char[2 * n];
        printParenthesis(str, 0, n, 0, 0);
        return parentheses;
    }
    private void printParenthesis(char[] str,int pos,int n ,int open,int close){
        if(close == n) {
            parentheses.add(new String(str));
            return;
        } else {
            if (open > close) {
                str[pos] = ')';
                printParenthesis(str, pos + 1, n, open, close + 1);
            }
            if(open < n) {
                str[pos] = '(';
                printParenthesis(str, pos + 1, n, open + 1, close);
            }
        }
    }
    private void print() {
        for(String p: parentheses) {
            System.out.println(p);
        }
    }
}
