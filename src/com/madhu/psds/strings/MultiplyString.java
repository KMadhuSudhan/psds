package com.madhu.psds.strings;
//https://leetcode.com/problems/multiply-strings/
//43. Multiply Strings

public class MultiplyString {
    public static void main(String[] args) {
        String num1 = "999";
        String num2 = "999";
        MultiplyString multiplyString = new MultiplyString();
        System.out.println(999*999);
       System.out.println(multiplyString.multiply(num1,num2));
    }

    public String multiply(String num1, String num2) {
//        String s1 = new StringBuffer(num1).reverse().toString();
//        String s2 = new StringBuffer(num2).reverse().toString();
        int num1Length = num1.length() -1;
        int num2Length = num2.length() -1;
        int totalLength = num1Length+num2Length;
        char[] num1Chars = num1.toCharArray();
        char[] num2Chars = num2.toCharArray();
        int[] resultArr = new int[totalLength];

        for(int i=0;i<num1Length;i++) {
            for(int j=0;j<num2Length;j++) {
                resultArr[i+j] = resultArr[i+j] + (num1Chars[i] - '0') * (num2Chars[j] - '0');
            }
        }
        for(int k=0;k<totalLength;k++) {
            System.out.print(resultArr[k] + " ");
        }

        System.out.println();

        String product = new String();
        int digit;
        int carry;
        for(int m =0;m<totalLength;m++) {
            carry = resultArr[m]/10;
            digit = resultArr[m]%10;
            if(m+1 <totalLength ) {
                resultArr[m + 1] = resultArr[m + 1] + carry;
            }
            product = digit + product;
        }
        return product;
    }
}
