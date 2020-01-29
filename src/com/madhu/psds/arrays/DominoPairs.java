package com.madhu.psds.arrays;

import java.util.HashMap;
import java.util.Map;

//1128 https://leetcode.com/problems/number-of-equivalent-domino-pairs/
public class DominoPairs {
    public static void main(String[] args) {
        int[][] pairs = new int[][]{{1,2},{2,1},{3,4},{5,6}};
        DominoPairs dominoPairs = new DominoPairs();
        dominoPairs.numEquivDominoPairs(pairs);
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int re = 0;
        Map<Integer,Integer> hm = new HashMap<>();
        for(int[] arr: dominoes) {
            int key = Math.max(arr[0], arr[1])*10 + Math.min(arr[0], arr[1]);
            int count =  hm.getOrDefault(key,0);
            hm.put(key, count+1);
        }
        for(int i : hm.keySet()) {
            int freq = hm.get(i);
            if(freq>1) {
                re+=freq/2;
            }
        }
        return re;
    }
}
