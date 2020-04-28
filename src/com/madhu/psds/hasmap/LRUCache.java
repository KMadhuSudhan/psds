package com.madhu.psds.hasmap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer,Integer> cache ;
    int N;

    public static void main(String[] args) {

    }
    public LRUCache(int capacity) {
      this.cache  = new LinkedHashMap<>();
      this.N = capacity;
    }

    public int get(int key) {
        int result = -1;
        if(this.cache.containsKey(key)) {
            result = cache.get(key);
            this.cache.remove(key);
            this.cache.put(key,result);
        }
        return result;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            this.cache.remove(key);
        } else  {
            if(this.cache.size() == this.N) {
                Integer firstKey = this.cache.keySet().iterator().next();
                this.cache.remove(firstKey);
            }
        }
        cache.put(key,value);
    }
}
