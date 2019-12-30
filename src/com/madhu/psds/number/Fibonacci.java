package com.madhu.psds.number;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fib(3));
    }

    public int fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;

        int x2 = 0;
        int x1 = 1;
        int xn = 0;

        for (int i = 2; i <= N; i++) {
            xn = x1 + x2;
            x2 = x1;
            x1 = xn;
        }

        return xn;
    }
}
