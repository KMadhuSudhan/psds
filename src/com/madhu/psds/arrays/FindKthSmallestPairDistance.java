package com.madhu.psds.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthSmallestPairDistance {
    public static void main(String[] args) {
        int[] arr = {1,3,1};
        FindKthSmallestPairDistance findKthSmallestPairDistance = new FindKthSmallestPairDistance();
        System.out.println(findKthSmallestPairDistance.smallestDistancePair(arr,1));
    }

    public int smallestDistancePair(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
             return   o1.compareTo(o2);
            }
        });
        int length= nums.length;
        for (int i=0;i<length;i++) {
            for (int j=i+1;j<length;j++) {
                int diff = Math.abs(nums[i] - nums[j]);
                pq.offer(diff);
            }
        }
        int count = 0;
        while (count<(k-1)) {
           System.out.println(pq.poll());
        }
        return pq.poll();
    }
}
