package com.madhu.psds.hasmap;
//https://leetcode.com/problems/minimum-index-sum-of-two-lists/
//599. Minimum Index Sum of Two Lists

import java.util.*;

public class MinimumIndexSumOfTwoLists {
    public static void main(String[] args) {
        MinimumIndexSumOfTwoLists minimumIndexSumOfTwoLists = new MinimumIndexSumOfTwoLists();
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        minimumIndexSumOfTwoLists.findRestaurant(list1, list2);
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        int minSum = Integer.MAX_VALUE, i = 0, size = 0;
        List<String> result = new ArrayList<>();
        while (i < list1.length) {
            map.put(list1[i], i++);
        }
        i = 0;
        while (i < list2.length && i <= minSum) {
            if (map.containsKey(list2[i])) {
                int sum = i + map.get(list2[i]);
                if (sum < minSum) {
                    result = new ArrayList<>();
                    result.add(list2[i]);
                    size = 1;
                    minSum = sum;
                } else if (sum == minSum) {
                    result.add(list2[i]);
                    size++;
                }
            }
            i++;
        }
        String[] ans = new String[size];
        int j = 0;
        for (String str : result) {
            ans[j++] = str;
        }
        return ans;
    }
}
