package com.madhu.psds.arrays;
//https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
//1431. Kids With the Greatest Number of Candies

import java.util.ArrayList;
import java.util.List;

public class KidsWiththeGreatestNumberOfCandies {
    public static void main(String[] args) {
        int[] nums = {2,3,5,1,3};
        KidsWiththeGreatestNumberOfCandies kidsWiththeGreatestNumberOfCandies = new KidsWiththeGreatestNumberOfCandies();
        kidsWiththeGreatestNumberOfCandies.kidsWithCandies(nums,3);
    }
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i=0;i<candies.length;i++) {
            max = Math.max(max,candies[i]);
        }
        for (int i=0;i<candies.length;i++) {
            ans.add((candies[i]+extraCandies) >= max);
        }
        return ans;
    }
}
