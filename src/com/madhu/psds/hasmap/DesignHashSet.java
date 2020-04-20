package com.madhu.psds.hasmap;
//https://leetcode.com/problems/design-hashset
//705. Design HashSet

import java.util.ArrayList;

public class DesignHashSet {
    private ArrayList<Integer>[] container;
    /** Initialize your data structure here. */
    public void MyHashSet() {
        container = new ArrayList[1000];
    }

    private int hash(int key){
        return key % 1000;
    }

    public void add(int key) {
        int hashCode = hash(key);
        if(container[hashCode] == null) {
            container[hashCode] = new ArrayList<>();
        }
        if(!container[hashCode].contains(key))container[hashCode].add(key);
    }

    public void remove(int key) {
        int hashCode = hash(key);
        if(container[hashCode] == null) return;
        if(container[hashCode].indexOf(key) > -1) {
            container[hashCode].remove(container[hashCode].indexOf(key));
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashCode = hash(key);
        if(container[hashCode] == null) return false;
        return container[hashCode].contains(key);
    }
}
