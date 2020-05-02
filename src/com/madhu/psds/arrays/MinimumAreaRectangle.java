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
        for (int[] p : points) {
            allPoints.add(new Point(p[0], p[1]));
        }
        for (int i = 0; i < points.length; ++i)
            for (int j = i + 1; j < points.length; ++j) {

                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];

                if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) {
                    Point p1 = new Point(x1, y1);
                    Point p2 = new Point(x2, y2);
                    Point p3 = new Point(p1.x, p2.y);
                    Point p4 = new Point(p2.x, p1.y);

                    if (allPoints.contains(p3) && allPoints.contains(p4)) {
                        int area = Math.abs(p1.x - p2.x) * Math.abs(p1.y - p2.y);
                        result = Math.min(area, result);
                    }
                }
            }
        if (result == Integer.MAX_VALUE) return 0;
        return result;
    }

    class Point {
        int x, y;

        Point(int i, int j) {
            x = i;
            y = j;
        }

        @Override
        public boolean equals(Object obj) {
            return (((Point) obj).x == this.x) && (((Point) obj).y == this.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
