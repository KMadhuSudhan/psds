package com.madhu.psds.strings;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        String str = "abcdefg";
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.reverseStr(str, 2));
    }

    public String reverseStr(String s, int k) {
        int length = s.length();
        char[] charArray = s.toCharArray();
        if (length < k) {
            reverse(charArray, 0, length);
            return new String(charArray);
        }
        boolean needToRev = true;
        int startPoint = 0;
        int i;
        for (i = 0; i < length; i++) {
            if ((i + 1) % k == 0) {
                if (needToRev) {
                    reverse(charArray, startPoint, i);
                    startPoint = i + k  +1;
                    i+=k-1;
                    needToRev = false;
                } else {
                    needToRev = true;
                }
            }
        }
        if(startPoint < length && needToRev) {
            reverse(charArray, startPoint,length-1);
        }
        return new String(charArray);
    }

    public void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
