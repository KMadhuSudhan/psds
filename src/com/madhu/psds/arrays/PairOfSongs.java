package com.madhu.psds.arrays;

import java.util.HashMap;
import java.util.Map;

public class PairOfSongs {
    public static void main(String[] args) {
        int[] songs = new int[]{30,20,150,100,40};
        PairOfSongs pairOfSongs = new PairOfSongs();
    }

    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer,Integer> pairs = new HashMap<>();
        int ans = 0;
        for(int song: time) {
            int r = song%60;
            int key = (song - r) % 60;

            if(pairs.containsKey(key)) {
                int count = pairs.get(key);
                ans+=count;
                pairs.put(key,count+1);

            }

            if(pairs.containsKey(key)) {
                int count = pairs.get(key);
                pairs.put(key,count+1);
            }
            else {
                pairs.put(key,1);
            }
        }
        return ans;
    }
}
