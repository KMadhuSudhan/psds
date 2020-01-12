package com.madhu.psds.bits;

public class NumberComplement {
    public static void main(String[] args) {
        NumberComplement numberComplement = new NumberComplement();
        System.out.println(numberComplement.findComplement(1111));
    }
    public int findComplement(int num) {
        int res = 0;
        int m = 1;
        while (num != 0) {
            if ((num & 1) == 0) {
                res += m;
            }
            m = m << 1;
            num = num >> 1;
        }
        return res;
    }
}
