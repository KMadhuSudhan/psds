package com.madhu.psds.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArrayWithSumZero {
    public static void main(String[] args) {
        SubArrayWithSumZero subArrayWithSumZero = new SubArrayWithSumZero();
        int[] A = {2,-2,3,0,4,-7};
        System.out.println(subArrayWithSumZero.solution(A));
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        Map<Integer,List<Integer>> hashMap = new HashMap();
        List<Integer> initialArray = new ArrayList();
        initialArray.add(-1);
        hashMap.put(0,initialArray);
        int sum = 0;
        int count = 0;
        for(int i=0;i<A.length;i++) {
            sum+=A[i];
            if(hashMap.containsKey(sum)) {
                count++;
            }
            if(!hashMap.containsKey(sum)) {
                List<Integer> newArray = new ArrayList();
                hashMap.put(sum,newArray);
            }
            hashMap.get(sum).add(i);
        }
        return count;
    }
}
