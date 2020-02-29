package com.madhu.psds.number;
//https://leetcode.com/problems/ugly-number-iii/
//1201. Ugly Number III

public class UglyNumberIII {
    public static void main(String[] args) {
        UglyNumberIII uglyNumberIII = new UglyNumberIII();
        System.out.println(uglyNumberIII.nthUglyNumber(4, 2, 3, 4));
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        if (n <= 0) return 0;
        int[] arr = new int[n];
        int i=0;
        arr[i] = a;
        int aFactorIndex = 0;
        for(i=1;arr[i-1] * arr[i-1]<b;i++) {
            arr[i] = arr[i-1] * arr[i-1];
        }
        int bFactorIndex = i;
        arr[i++] = b;

        for(int k=0;k<i;k++) {
            for (int j =0;j<i && arr[k]*arr[j] < c;j++) {
                arr[i++] = arr[k]*arr[j];
            }
        }
        int cFactorIndex = i;
        if(n<=i) return arr[i-1];
        arr[i++] = c;
        for (int k = i; k < n; k++) {
            int aFactor = a * arr[aFactorIndex];
            int bFactor = b * arr[bFactorIndex];
            int cFactor = c * arr[cFactorIndex];
            int minFactor = Math.min(aFactor, Math.min(bFactor, cFactor));
            arr[i] = minFactor;
            if (aFactor == minFactor) aFactorIndex++;
            if (bFactor == minFactor) bFactorIndex++;
            if (cFactor == minFactor) cFactorIndex++;
        }
        return arr[n - 1];
    }
}
