package com.madhu.psds.arrays;
//https://leetcode.com/problems/partition-array-into-disjoint-intervals/
//915. Partition Array into Disjoint Intervals

public class PartitionArrayIntoDisjointIntervals {
    public static void main(String[] args) {
        PartitionArrayIntoDisjointIntervals partitionArrayIntoDisjointIntervals = new PartitionArrayIntoDisjointIntervals();
        int[] nums = {1, 1};
        System.out.println(partitionArrayIntoDisjointIntervals.partitionDisjoint(nums));
    }

    public int partitionDisjoint(int[] A) {
        int firstMax = A[0], i = 0, length = A.length;
        int count = 1;
        while (i < length - 2) {
            boolean foundMin = true;
            for (int j = i + 1; j < length; j++) {
                if (A[j] < firstMax) {
                    foundMin = false;
                    break;
                }
            }
            if (foundMin) break;
            firstMax = Math.max(firstMax, A[i]);
            i++;
            count++;
        }
        return count;
    }
}
