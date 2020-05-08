package com.madhu.psds.arrays;
//https://leetcode.com/problems/sort-integers-by-the-power-value/
//1387. Sort Integers by The Power Value

import java.util.*;

public class SortIntegersByThePowerValue {
    public static void main(String[] args) {
        SortIntegersByThePowerValue sortIntegersByThePowerValue = new SortIntegersByThePowerValue();
        System.out.println(sortIntegersByThePowerValue.getKth(1,1000,777));
    }

    public int getKth(int lo, int hi, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[1] != b[1]) {
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });

        for(int i = lo; i <= hi; i++){
            pq.add(new int[]{i, getPower(i)});
        }

        while(!pq.isEmpty() && k > 1) {
            pq.poll();
            k--;
        }
        return pq.poll()[0];
    }

    int getPower(int n) {
        int count =0;
        while (n!=1) {
            if(n%2 == 0) {
                n /=2;
            } else {
                n = 3*n  +1;
            }
            count++;
        }
        return count;
    }
}
