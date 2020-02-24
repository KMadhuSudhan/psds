package com.madhu.psds.arrays;
//https://leetcode.com/problems/string-compression/
//443. String Compression

public class StringCompression {
    public static void main(String[] args) {
        char[] strChars = {'a','a','b','b','c','c','c'};
        StringCompression stringCompression = new StringCompression();
        stringCompression.compress(strChars);
    }

    public int compress(char[] chars) {
        int pos = 0, cnt = 0;
        for (int i = 0; i < chars.length; i++) {
            cnt++;
            if (i + 1 == chars.length || chars[i] != chars[i + 1]) {
                chars[pos++] = chars[i];
                if (cnt > 1) for (char c : Integer.toString(cnt).toCharArray()) chars[pos++] = c;
                cnt = 0;
            }
        }
        return pos;
    }
}
