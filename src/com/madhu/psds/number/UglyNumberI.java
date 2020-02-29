package com.madhu.psds.number;
//https://leetcode.com/problems/ugly-number/
//263. Ugly Number

public class UglyNumberI {
    public static void main(String[] args) {
        UglyNumberI uglyNumberI = new UglyNumberI();
        System.out.println(uglyNumberI.isUgly(6));
    }

    public boolean isUgly(int num) {
        if (num == 1) return true;
        int target;
        while (true) {
            target = num;
            if (num % 5 == 0) num /= 5;
            else if (num % 3 == 0) num /= 3;
            else if (num % 2 == 0) num /= 2;
            if (num == 1) return true;
            if (num == target) return false;
        }
    }
}
