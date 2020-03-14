package com.madhu.psds.strings;
//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
//1249. Minimum Remove to Make Valid Parentheses

public class MakeValidParentheses {
    public static void main(String[] args) {
        MakeValidParentheses makeValidParentheses = new MakeValidParentheses();
        String str = "lee(t(c)o)de)";
        makeValidParentheses.minRemoveToMakeValid(str);
    }

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for(char c : s.toCharArray()) {
            if(c==')') {
                if(open == 0) continue;
                open--;
            } else if(c == '(') {
                open++;
            }
            sb.append(c);
        }

        if(open == 0) return sb.toString();

        StringBuilder sol = new StringBuilder();
        for(int i = sb.length()-1; i>=0; i--) {
            if(sb.charAt(i) == '(' && open-- > 0) continue;
            else sol.append(sb.charAt(i));
        }
        return sol.reverse().toString();
    }
}
