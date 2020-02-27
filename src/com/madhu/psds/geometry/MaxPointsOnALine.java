package com.madhu.psds.geometry;
//https://leetcode.com/problems/max-points-on-a-line/
//149. Max Points on a Line

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxPointsOnALine {
    public static void main(String[] args) {
        int[][] points = new int[][] {
                {1,1},{3,2},{5,3},{4,1},{2,3},{1,4}
        };
//        int[][] points = new int[][] {
//                {1,1},
//                {1,1},
//                {2,3}
//        };
//        int[][] points = new int[][] {
//                {1,1},{2,1},{2,2},{1,4},{3,3}
//        };
        MaxPointsOnALine maxPointsOnALine = new MaxPointsOnALine();
        System.out.println(maxPointsOnALine.maxPoints(points));
    }
//    public int maxPoints(int[][] coords) {
//        int length = coords.length;
//        if(length == 1) return 1;
//        if(length == 2) return 2;
//        boolean firstTwoPointsNotCounted = true;
//        int count = 0;
//        for(int i=2;i<coords.length -1;i++){
//            for(int j = i+1;j<coords.length;j++) {
//                int total = coords[0][0] * (coords[1][1] - coords[i][1]) + coords[1][0] * (coords[i][1] - coords[0][1]) + coords[i][0] * (coords[0][1] - coords[1][1]);
//                if (total == 0 && firstTwoPointsNotCounted) {
//                    count = 3;
//                } else if (total == 0) {
//                    count++;
//                    firstTwoPointsNotCounted = false;
//                }
//            }
//        }
//        return count;
//    }
    public int maxPoints(int[][] coords) {
        int length = coords.length;
        if(length == 1) return 1;
        Map<Double,Set<Integer>> map = new HashMap<>();
        double slope;
        int infinityCount = 0;
        for(int i=0;i<coords.length-1;i++) {
            for(int j=i+1;j<coords.length;j++) {
                if((coords[j][0] - coords[i][0]) == 0) {
                    if(infinityCount == 0) {
                        infinityCount = 2;
                    } else {
                        infinityCount++;
                    }
                }
                slope = (double) (coords[j][1] - coords[i][1]) / (double) (coords[j][0] - coords[i][0]);
                if(slope == -0.0) slope = Math.abs(slope);
                if(map.get(slope) == null) {
                    Set<Integer> set = new HashSet();
                    set.add(i);
                    set.add(j);
                    map.put(slope,set);
                } else {
                    Set<Integer> set = map.get(slope);
                    set.add(i);
                    set.add(j);
                    map.put(slope,set);
                }
            }
        }
        int max = 0;
        for(Map.Entry<Double,Set<Integer>> entry: map.entrySet()) {
            max = Math.max(max,entry.getValue().size());
        }
        max = Math.max(infinityCount,max);
        return max;
    }
}
