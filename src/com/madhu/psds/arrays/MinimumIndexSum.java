package com.madhu.psds.arrays;

//https://leetcode.com/problems/minimum-index-sum-of-two-lists/
public class MinimumIndexSum {
    public static void main(String[] args) {
        String[] st1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] st2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        MinimumIndexSum minimumIndexSum = new MinimumIndexSum();
        System.out.println(minimumIndexSum.findRestaurant(st1, st2));
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        String indexSum = "";
        for (String st1 : list1) {
            boolean flag = false;
            for (String st2 : list2) {
                if (st1.equals(st2)) {
                    indexSum = st1;
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

        return new String[]{indexSum};
    }
}
