package com.madhu.psds.strings;
//https://leetcode.com/problems/remove-k-digits/submissions/
//402. Remove K Digits

import java.util.Deque;
import java.util.LinkedList;

public class RemoveKDigits {
    public static void main(String[] args) {
        RemoveKDigits removeKDigits = new RemoveKDigits();
        removeKDigits.removeKdigits("1432219", 3);
    }

    public String removeKdigits(String num, int k) {
        Deque<Character> result = new LinkedList<>();
        char[] chars = num.toCharArray();
        if (k >= num.length()) return "0";
        for (char c : chars) {
            while (k > 0 && result.size() > 0 && result.peekLast() > c) {
                result.pollLast();
                k--;
            }
            if (!(result.size() == 0 && c == '0')) result.addLast(c);
        }
        StringBuilder sb = new StringBuilder();
        if(result.size() == 0) return "0";
        while (!result.isEmpty()) {
            sb.append(result.pollFirst());
        }
        return sb.toString().substring(0,sb.length() - k);
    }

    public String removeKdigitsStack(String num, int k) {
        int digits = num.length() - k;
        if (num.length() <= k) return "0";
        int top = -1, start = 0;
        char[] st = num.toCharArray();
        for (int i = 0; i < st.length; i++) {
            while (top >= 0 && st[top] > st[i] && k > 0) {
                top--;
                k--;
            }
            st[++top] = st[i];
        }
        while (start <= top && st[start] == '0') start++;
        if (start > top) return "0";
        return new String(st, start, digits - start);
    }
}
