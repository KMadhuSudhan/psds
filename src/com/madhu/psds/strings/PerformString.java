package com.madhu.psds.strings;

public class PerformString {
    public static void main(String[] args) {
        PerformString performString = new PerformString();
        String s = "abc";
        int[][] shift = {
                {0,1},
                {1,2}
        };
        System.out.println(performString.stringShift(s,shift));
    }

    public String stringShift(String s, int[][] shift) {
        char[] chars = s.toCharArray();
        int end = chars.length-1;
        int shiftsLength = shift.length;
        for (int i = 0; i < shiftsLength; i++) {
            if (shift[i][0] == 0) {
                leftRotation(chars,shift[i][1],end);
            } else {
                leftRotation(chars,end - shift[i][1] + 1,end);
            }
        }
        return new String(chars);
    }

    void  leftRotation(char[] chars ,int d,int end) {
        reverse(chars, 0, d - 1);
        reverse(chars, d, end);
        reverse(chars, 0, end);
    }
    void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
