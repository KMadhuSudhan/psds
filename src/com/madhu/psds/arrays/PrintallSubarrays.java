package com.madhu.psds.arrays;

import java.util.*;

public class PrintallSubarrays {
    private <K,V> void insert(Map<K, List<V>> hashMap, K key, V value)
    {
        if (!hashMap.containsKey(key)) {
            hashMap.put(key, new ArrayList<>());
        }
        hashMap.get(key).add(value);
    }

    public void printallSubarrays(int[] A)
    {
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        insert(hashMap, 0, -1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++)
        {
            sum += A[i];
            if (hashMap.containsKey(sum))
            {
                List<Integer> list = hashMap.get(sum);
                for (Integer value: list) {
                    System.out.println("Subarray [" + (value + 1) + ".." +
                            i + "]");
                }
            }

            insert(hashMap, sum, i);
        }
    }
    public static void main (String[] args)
    {
        int[] A = { 2,-2,3,0,4,-7 };
        PrintallSubarrays printallSubarrays = new PrintallSubarrays();
        printallSubarrays.printallSubarrays(A);
    }
}
