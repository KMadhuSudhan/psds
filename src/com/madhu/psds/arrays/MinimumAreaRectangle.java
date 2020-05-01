package com.madhu.psds.arrays;
//https://leetcode.com/problems/minimum-area-rectangle/
//939. Minimum Area Rectangle

import java.util.*;

public class MinimumAreaRectangle {
    public static void main(String[] args) {
        MinimumAreaRectangle minimumAreaRectangle = new MinimumAreaRectangle();
        int[][] points = {
                {1, 1},
                {1, 3},
                {3, 1},
                {3, 3},
                {2, 2}
        };
        minimumAreaRectangle.minAreaRect(points);
    }

    public int minAreaRect(int[][] points) {
        int result = Integer.MAX_VALUE;
        Set<Point> allPoints = new HashSet<>();
        for(int[] p:points){
            allPoints.add(new Point(p[0],p[1]));
        }
        for(Point p1: allPoints) {
            for (Point p2: allPoints) {
                if(p1.equals(p2) || p1.x == p2.x || p2.y==p1.y) continue;
                Point p3 = new Point(p1.x,p2.y);
                Point p4 = new Point(p2.x,p1.y);
                if(allPoints.contains(p3) && allPoints.contains(p4)){
                    int area = Math.abs(p1.x-p2.x)*Math.abs(p1.y-p2.y);
                    result = Math.min(area,result);
                }
            }
        }
        if(result==Integer.MAX_VALUE) return 0;
        return result;
    }

    class Point{
        int x, y;
        Point(int i, int j){ x =i; y =j; }
        @Override
        public boolean equals(Object obj){
            return (((Point) obj).x == this.x) && (((Point) obj).y == this.y);
        }

        @Override
        public int hashCode(){ return Objects.hash(x,y); }
    }
}
