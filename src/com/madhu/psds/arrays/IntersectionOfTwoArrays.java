package com.madhu.psds.arrays;

import java.util.*;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        intersectionOfTwoArrays.intersection(nums1,nums2);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer> num1Map = new HashMap();
        Map<Integer,Integer> num2Map = new HashMap();
        for(int num1: nums1) {
            int count = num1Map.getOrDefault(num1,0);
            num1Map.put(num1,count+1);
        }
        for(int num2: nums2) {
            int count = num2Map.getOrDefault(num2,0);
            num2Map.put(num2,count+1);
        }
        Set<Integer> integerList = new HashSet<>();
        for(Map.Entry<Integer,Integer> entry: num1Map.entrySet()) {
            if( num2Map.containsKey(entry.getKey())){
                integerList.add(entry.getKey());
            }
        }
        int[] result = new int[integerList.size()];
        int i =0;
        for(int num: integerList) {
            result[i++] = num;
        }
        return result;
    }
}
