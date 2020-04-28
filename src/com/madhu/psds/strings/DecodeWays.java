package com.madhu.psds.strings;
//https://leetcode.com/problems/decode-ways/
//91. Decode Ways

public class DecodeWays {
    public static void main(String[] args) {
        String s = "226";
        DecodeWays decodeWays = new DecodeWays();
        decodeWays.numDecodings(s);
    }
    public int numDecodings(String s) {
        int first = 1;
        char[] chars = s.toCharArray();
        int length = chars.length;
        int second = chars[0] == '0' ? 0 : 1;
        for(int i = 2; i <= length; i++){
            int oneDigit = chars[i-1] - 48;
            int twoDigit = (chars[i-2] - 48) * 10  + oneDigit ; //Integer.valueOf(new String("" + chars[i-2] + chars[i-1]));
            int fib = 0;
            if(oneDigit >= 1){
                fib += second;
            }

            if(twoDigit >= 10 && twoDigit <= 26){
                fib += first;
            }

            first = second;
            second = fib;
        }
        return second;
    }
}
