package com.madhu.psds.number;
//https://leetcode.com/problems/powx-n/
//50. Pow(x, n)

public class Pow {
    public static void main(String[] args) {
        Pow pow = new Pow();
        pow.myPow(2.0, 10);
    }

    public double myPow(double x, int n) {
        if (n >= 0) {
            return pow(x, n);
        } else {
            return pow(1 / x, n);
        }
    }

    public double pow(double x, int n) {
        if (n == 0) return 1;
        return pow(x * x, n / 2) * (n % 2 == 0 ? 1 : x);
    }
}