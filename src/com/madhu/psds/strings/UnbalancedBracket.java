package com.madhu.psds.strings;
//https://www.geeksforgeeks.org/convert-an-unbalanced-bracket-sequence-to-a-balanced-sequence/

public class UnbalancedBracket {
    public static void main(String[] args) {
        String str = "(((())())(())())";
        UnbalancedBracket unbalancedBracket = new UnbalancedBracket();
       System.out.println(unbalancedBracket.balancedBrackets(str));
    }

    String balancedBrackets(String str) {
        int length = str.length();
        int minDeep = 0;
        int deep = 0;
        char[] brackets = str.toCharArray();

        for (int i = 0; i < length; i++) {
            if (brackets[i] == '(') {
                deep++;
            } else {
                deep--;
            }
            if (minDeep > deep) {
                minDeep = deep;
            }
        }
        if (minDeep < 0) {
            for (int i = 0; i < Math.abs(minDeep); i++) {
                str = "("  + str;
            }
        }
        deep = 0;
        brackets = str.toCharArray();
        length = brackets.length;

        for (int i = 0; i < length; i++) {
            if (brackets[i] == '(') {
                deep++;
            } else {
                deep--;
            }
        }
        if (deep != 0) {
            for (int i = 0; i < deep; i++) {
                str =  str + ")";
            }
        }
        return str;
    }
}
