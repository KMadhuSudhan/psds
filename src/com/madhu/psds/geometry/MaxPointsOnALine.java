package com.madhu.psds.geometry;
//https://leetcode.com/problems/max-points-on-a-line/
//149. Max Points on a Line

import org.omg.CORBA.MARSHAL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxPointsOnALine {
    public static void main(String[] args) {
//        int[][] points = new int[][]{
//                {1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}
//        };
//        int[][] points = new int[][] {
//                {1,1},
//                {1,1},
//                {2,3}
//        };
        int[][] points = new int[][] {
                {1,1},{2,1},{2,2},{1,4},{3,3}
        };
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
    public int maxPoints(int[][] points) {
        // if points less than or equal 2 return length
        if(points.length<=2)
            return points.length;
        int maxpoints=0;
        int length = points.length-1;
        for(int i=length;i>0;i--)
        {
            Map<Double,Integer> slopeMap = new HashMap<Double,Integer>();
            int duplicates=0;
            int max=0;
            for( int j=0;j<i;j++)
            {
                int [] p1 = points[j];
                int [] p2 = points[i];

                if(p2[1]==p1[1] && p1[0]==p2[0]){
                    duplicates++;
                    continue;
                }
                double  slope = Double.MAX_VALUE;
                if(p2[0]-p1[0]!=0)
                    slope = (double)(p2[1]-p1[1])/(p2[0]-p1[0]);
                if(slopeMap.containsKey(slope)){
                    int count= slopeMap.get(slope)+1;
                    slopeMap.put(slope,count);
                    max = Math.max(max,count);
                }else{
                    slopeMap.put(slope,1);
                    if(max<(1))
                        max=1;
                }
            }
            maxpoints= Math.max(maxpoints,max+duplicates);
        }
        return maxpoints+1;
    }
}
