package com.madhu.psds.bits;

public class AlterNativeBits {
    public static void main(String[] args) {
        AlterNativeBits alterNativeBits = new AlterNativeBits();
        System.out.println(alterNativeBits.hasAlternatingBits(7));
    }

    public boolean hasAlternatingBits(int n) {
        int previousBit = n % 2;
        n = n / 2;
        while (n > 0) {
            int r = n % 2;
            if (r == previousBit) {
                return false;
            }
            n = n / 2;
            previousBit = r;
        }
        return true;
    }
}
