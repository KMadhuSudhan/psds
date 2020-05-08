package com.madhu.psds.arrays;
//https://leetcode.com/problems/random-pick-with-blacklist/
//710. Random Pick with Blacklist

import java.util.*;

public class RandomPickWithBlacklist {
    Map<Integer,Integer> map;
    Set<Integer> set;
    int current,len;
    Random rand;

    public RandomPickWithBlacklist(int N, int[] blacklist) {
        map=new HashMap<>();
        set=new HashSet<>();
        rand=new Random();
        current=N-1;
        len=N-blacklist.length;

        for (int i=0;i<blacklist.length;i++){
            set.add(blacklist[i]);
            if (blacklist[i]<len){
                map.put(blacklist[i],0);
            }
        }
        for (int key:map.keySet()){
            while (set.contains(current)){
                current--;
            }
            map.put(key,current--);
        }
    }

    public int pick() {
        int temp=rand.nextInt(len);
        return map.containsKey(temp)?map.get(temp):temp;
    }
}
