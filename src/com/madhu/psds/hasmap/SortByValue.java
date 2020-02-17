package com.madhu.psds.hasmap;

import java.util.*;

public class SortByValue {
    public Map<String,Integer> SortByValue(Map<String,Integer>  map) {
        List<Map.Entry<String,Integer>> list = new LinkedList(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        HashMap<String,Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String,Integer> eachEntry: list) {
            temp.put(eachEntry.getKey(),eachEntry.getValue());
        }
        return temp;
    }
    public static void main(String[] args) {
        SortByValue sortByValue = new SortByValue();
        Map<String,Integer> map = new HashMap<>();
        map.put("madhu",5);
        map.put("uday",10);
        map.put("ashok",20);
        map.put("chirant",15);
        map.put("uma",5);
        map.put("deedp",12);
        map.put("jibin",16);
        Map<String,Integer> sortedMap = sortByValue.SortByValue(map);
        System.out.println(sortedMap);
    }
}
