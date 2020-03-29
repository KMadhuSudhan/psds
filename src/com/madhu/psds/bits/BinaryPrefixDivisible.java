package com.madhu.psds.bits;
//https://leetcode.com/problems/binary-prefix-divisible-by-5/
//1018. Binary Prefix Divisible By 5

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisible {
    public static void main(String[] args) {
        BinaryPrefixDivisible binaryPrefixDivisible = new BinaryPrefixDivisible();
        int[] nums = {0,1,1};
        binaryPrefixDivisible.prefixesDivBy5(nums);
    }
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ret = new ArrayList<>();
        int c = 0;
        for (int a : A) {
            c = (c<<1 | a)%5;
            ret.add(c==0);
        }

        return ret;
    }
}
