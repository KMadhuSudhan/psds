package com.madhu.psds.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxSumOperaitonsAfterK {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue(Comparator.reverseOrder());
        int[] nums = {10,40,30,20,50};
        int sum = 0;
        int k =3;
        for(int i =0;i<nums.length;i++) {
            priorityQueue.add(nums[i]);
            sum+=nums[i];
        }
        while (k-->0) {
            int pop = priorityQueue.poll();
            System.out.println(pop);
            int result = priorityQueue.poll() / 2;
            sum = sum - result;
            priorityQueue.add(result);
        }
        System.out.println(sum );
    }
}
