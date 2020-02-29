package com.madhu.psds.number;
//https://leetcode.com/problems/ugly-number-ii/
//264. Ugly Number II

public class UglyNumberII {
    public static void main(String[] args) {
        UglyNumberII uglyNumberII = new UglyNumberII();
        System.out.println(uglyNumberII.nthUglyNumber(1352,2,3,5));
    }

    public int nthUglyNumber(int n,int a,int b,int c) {
        if(n<=0) return 0;
        int aFactorIndex=0;
        int bFactorIndex=0;
        int cFactorIndex=0;
        int[] arr = new int[n];
        arr[0] = 1;
        for(int i=1;i<n;i++) {
            int aFactor = a*arr[aFactorIndex];
            int bFactor = b*arr[bFactorIndex];
            int cFactor = c*arr[cFactorIndex];
            int minFactor = Math.min(aFactor,Math.min(bFactor,cFactor));
            arr[i] = minFactor;
            if(aFactor == minFactor) aFactorIndex++;
            if(bFactor == minFactor) bFactorIndex++;
            if(cFactor == minFactor) cFactorIndex++;
        }
        return arr[n-1];
    }
}
