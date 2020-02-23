package com.madhu.psds.arrays;

import java.util.*;

public class TopKFreqElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < length; i++) {
            int count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], count + 1);
        }
        List<Integer> result = new ArrayList<>();
        List<Map.Entry<Integer, Integer>> temp = sortByFreq(map);
        for (Map.Entry<Integer, Integer> entry : temp) {
            if (k == 0) break;
            result.add(entry.getKey());
            k--;
        }
        return result;
    }

    List<Map.Entry<Integer, Integer>> sortByFreq(Map<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> list = new LinkedList(map.entrySet());
        Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };
        Collections.sort(list, comparator);
        return list;
    }

    public static void main(String[] args) {
        TopKFreqElements topKFreqElements = new TopKFreqElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        topKFreqElements.topKFrequent(nums, 2);
    }
}
