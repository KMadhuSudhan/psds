package com.madhu.psds.arrays;
//https://leetcode.com/problems/kth-largest-element-in-a-stream/submissions/
//703. Kth Largest Element in a Stream

import java.util.PriorityQueue;

public class KthLargestElementFromTheStream {
    PriorityQueue<Integer> q;
    int k;
    public void KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<Integer>(k);
        for (int a :nums)  add(a);
    }

    public int add(int val) {
        q.offer(val);
        if (q.size() > k)   q.poll();
        return q.peek();
    }
}
