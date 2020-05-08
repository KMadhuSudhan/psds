package com.madhu.psds.arrays;
//https://leetcode.com/problems/longest-well-performing-interval/
//1124. Longest Well-Performing Interval

import java.util.HashMap;

public class LongestWellPerformingInterval {

    public static void main(String[] args) {
        int[] nums = {9,9,6,0,6,6,9};
        LongestWellPerformingInterval longestWellPerformingInterval = new LongestWellPerformingInterval();
        longestWellPerformingInterval.longestWPI(nums);
    }
    public int longestWPI(int[] hours) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int ans =0;
        int score = 0;
        int N = hours.length;
        //if score is >0 then is favorable solution
        for(int i =0;i<N;i++)
        {
            score+= hours[i]>8?1:-1;
            if(score>0)
            {
                ans = i+1;
            }
            else
            {
                map.putIfAbsent(score, i); //check if same score occur twice in map then in that interval there are equal no of tiring and non tiring day
                if(map.containsKey(score-1))
                {
                    ans = Math.max(ans, i-map.get(score-1));
                }
            }
        }

        return ans;
    }
}
