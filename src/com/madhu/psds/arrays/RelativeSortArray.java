package com.madhu.psds.arrays;

import java.util.HashMap;
import java.util.Map;

public class RelativeSortArray {
    public static void main(String[] args) {
        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = new int[]{2,1,4,3,9,6};
        RelativeSortArray relativeSortArray = new RelativeSortArray();
        relativeSortArray.relativeSortArray(arr1,arr2);
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> countMap = new HashMap();
        for(int element: arr1) {
            int count = countMap.getOrDefault(element,0);
            countMap.put(element,count+1);
        }
        int arragedCount = 0;
        for(int ele: arr2) {
           int repeatedCount  = countMap.get(ele);
            arragedCount+=repeatedCount;
           for (int i =0;i<repeatedCount;i++) {
               arr1[i] = ele;
           }
        }
        return arr1;
    }
}
