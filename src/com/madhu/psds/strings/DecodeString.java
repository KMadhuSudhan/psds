package com.madhu.psds.strings;
//https://leetcode.com/problems/decoded-string-at-index/
//880. Decoded String at Index

public class DecodeString {
    public static void main(String[] args) {
        String s = "y959q969u3hb22odq595";
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeAtIndex(s, 222280369));
    }

    public String decodeAtIndex(String S, int K) {
        char[] chars = S.toCharArray();
        if (S == null || S.trim().length() == 0 || K <= 0){
            return null;
        }

        long count = 0;
        int index;
        for (index = 0; index< S.length(); index++){

            char c = chars[index];
            if (c>='a'&&c<='z'){
                count++;
            } else {
                int d = c - 0x30;
                count *= d;
            }

            if (count>=K){
                break;
            }
        }


        return helper(S, index, K, count);
    }

    private String helper(String S, int index, long K, long count){

        char c = S.charAt(index);
        if (c >='a'&& c<='z'){

            if (K == count){

                return String.valueOf(c);
            }

            count -= 1;
            index -= 1;
        } else {

            int d = c - 0x30;
            count /= d;
            K = K%count;
            index -= 1;
        }

        return helper(S, index, K, count);
    }


    public String decodeAtIndexWith30Percent(String S, int K) {
        char[] chars = S.toCharArray();
        long length = 0;
        for (int i=0;i<chars.length;i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                length = length*(chars[i] - '0');
            } else {
                length++;
            }
        }
        if(length == 0){
            return null;
        }
        for(int i = chars.length-1;i>=0;i--) {
            K = (int) (K % length);
            if(K == 0 && Character.isLetter(chars[i])) {
                return new String("" + chars[i]);
            }
            if (chars[i] >= '0' && chars[i] <= '9') {
                length = length/(chars[i] - '0');
            } else {
                length--;
            }
        }
        return null;
    }


}
