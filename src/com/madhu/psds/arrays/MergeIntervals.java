package com.madhu.psds.arrays;
//https://leetcode.com/problems/merge-intervals/
//56. Merge Intervals

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][] {
                {1,3},
                {0,2},
                {2,3},
                {4,6},
                {4,5},
                {5,5},
                {0,2},
                {3,3}
        };
        MergeIntervals mergeIntervals = new MergeIntervals();
        System.out.println(mergeIntervals.merge(intervals));
    }
    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if(length == 0) return new int[][]{};
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int min = intervals[0][0],max = intervals[0][1];
        for (int i=1;i<length;i++) {
            if(intervals[i][0] <= max) {
                min = Math.min(min, intervals[i][0]);
                max = Math.max(max, intervals[i][1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(min);
                list.add(max);
                lists.add(list);
                min = intervals[i][0];
                max = intervals[i][1];
            }
        }

        List<Integer> lastInterval = new ArrayList<>();
        lastInterval.add(min);
        lastInterval.add(max);
        lists.add(lastInterval);

        int[][] result = new int[lists.size()][2];
        for (int i=0;i<lists.size();i++) {
            List<Integer> list = lists.get(i);
            result[i] = new int[]{list.get(0),list.get(1)};
        }
        return result;
    }
}
