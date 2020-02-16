package com.madhu.psds.strings;
//https://leetcode.com/problems/add-strings/
//415. Add Strings

import java.util.HashMap;
import java.util.Map;

public class AddStringNumbers {
    public static void main(String[] args) {
        String num1 = "9";
        String num2 = "99";
        AddStringNumbers addStringNumbers = new AddStringNumbers();
        System.out.println(addStringNumbers.addStrings(num1, num2));
    }

    public String addStrings(String num1, String num2) {
        int num1Length = num1.length() -1;
        int num2Length = num2.length() -1;
        String result = "";
        char[] num1Chars = num1.toCharArray();
        char[] num2Chars = num2.toCharArray();
        int sum = 0;
        while (num1Length >= 0 && num2Length >= 0) {
            sum += (num1Chars[num1Length] - '0') + (num2Chars[num2Length] - '0');
            result = sum%10 + result;
            sum /=10;
            num1Length--;
            num2Length--;
        }

        while(num1Length>=0) {
            sum += (num1Chars[num1Length] - '0');
            result = sum%10 + result;
            sum /=10;
            num1Length--;
            num2Length--;
        }

        while(num2Length>=0) {
            sum += (num2Chars[num2Length] - '0');
            result = sum%10 + result;
            sum /=10;
            num1Length--;
            num2Length--;
        }

        if(sum!=0) result = sum + result;
        return result;
    }
}
