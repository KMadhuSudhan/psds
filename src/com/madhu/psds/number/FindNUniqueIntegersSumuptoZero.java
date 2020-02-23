package com.madhu.psds.number;
//https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
//1304. Find N Unique Integers Sum up to Zero

public class FindNUniqueIntegersSumuptoZero {

    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int i;
        int x=0;
        for(i=0;i<n-1;i++) {
            ans[i] = i+1;
            x += (i+1);
        }
        ans[n-1] = -x;
        return ans;
    }

    public static void main(String[] args) {
        FindNUniqueIntegersSumuptoZero findNUniqueIntegersSumuptoZero = new FindNUniqueIntegersSumuptoZero();
        findNUniqueIntegersSumuptoZero.sumZero(5);
    }
}
