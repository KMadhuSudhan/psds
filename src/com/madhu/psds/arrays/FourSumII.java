package com.madhu.psds.arrays;

import java.util.HashMap;
//https://leetcode.com/problems/4sum-ii/
//454. 4Sum II

public class FourSumII {
    public static void main(String[] args) {
        FourSumII fourSumII = new FourSumII();
        int[] a = {1, 2};
        int[] b = {-2,-1};
        int[] c = {-1, 2};
        int[] d = {0, 2};
        fourSumII.fourSumCount(a,b,c,d);
    }
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<C.length;i++){
            for(int j=0;j<D.length;j++){
                int sum = C[i] + D[j];
                if(!map.containsKey(sum)){
                    map.put(sum,1);
                }else{
                    map.put(sum,1+map.get(sum));
                }
            }
        }
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                int target = -(A[i]+B[j]);
                if(map.containsKey(target)){
                    count += map.get(target);
                }
            }
        }
        return count;
    }
}
