package com.madhu.psds.arrays;

import java.util.HashMap;
import java.util.Map;

public class CountElements {
    public static void main(String[] args) {
        int[] array = {1,1,3,3,5,5,7,7};
        CountElements countElements = new CountElements();
        countElements.countElements(array);
    }

    public int countElements(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num: arr) {
            int count =  map.getOrDefault(num,0);
            map.put(num,count+1);
        }
        int countElements = 0;
        for (int num: arr) {
            if(map.get(num+1)!=null) countElements++;
        }
        return countElements;
    }
}
