package com.madhu.psds.arrays;
//https://leetcode.com/problems/relative-ranks/
//506. Relative Ranks

import java.util.Comparator;
import java.util.PriorityQueue;

public class RelativeRanks {
    class Index {
        int index;
        int element;
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 3, 2, 1};
        RelativeRanks relativeRanks = new RelativeRanks();
        String[] result =  relativeRanks.findRelativeRanks(a);
        for (int i=0;i<a.length;i++) {
            System.out.println(result[i]);
        }
    }

    class RankComparator implements  Comparator<Index> {
        @Override
        public int compare(Index o1, Index o2) {
            return o2.element - o1.element;
        }
    }

    public String[] findRelativeRanks(int[] nums) {
        PriorityQueue<Index>  priorityQueue = new PriorityQueue(new RankComparator());
        int length = nums.length;
        for (int i=0;i<length;i++) {
            Index index = new Index();
            index.index = i;
            index.element = nums[i];
            priorityQueue.add(index);
        }
        String[] ranks = new String[length];
        String[] firstThreeRanks = {"Gold Medal","Silver Medal","Bronze Medal"};
        for(int i=0;i<length;i++) {
            Index currentRank = priorityQueue.poll();
            if(i<3) {
                ranks[currentRank.index] = firstThreeRanks[i];
                continue;
            }
            String rank = String.valueOf(i+1);
            ranks[currentRank.index] = rank;
        }
        return ranks;
    }
}
