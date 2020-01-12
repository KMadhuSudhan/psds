package com.madhu.psds.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = new int[]{2,7,4,1,8,1};
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        System.out.println(lastStoneWeight.lastStoneWeight(stones));
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int item : stones)queue.add(item);
        while (queue.size()>1){
            int i1 = queue.poll();
            int i2 = queue.poll();
            if (i1!=i2)queue.add(Math.abs(i1-i2));
        }
        return queue.isEmpty()?0:queue.poll();
    }
}
