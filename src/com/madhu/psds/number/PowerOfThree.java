package com.madhu.psds.number;

public class PowerOfThree {
    public static void main(String[] args) {
        PowerOfThree powerOfThree = new PowerOfThree();
        System.out.println(powerOfThree.isPowerOfThree(3));
    }

    public boolean isPowerOfThree(int n) {
        return n > 0 && Math.log10(n)/Math.log10(3) % 1 == 0;
    }
}