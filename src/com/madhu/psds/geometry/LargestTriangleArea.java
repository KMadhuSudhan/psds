package com.madhu.psds.geometry;

public class LargestTriangleArea {
    public static void main(String[] args) {
        int[][] points = new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}};
        LargestTriangleArea largestTriangleArea = new LargestTriangleArea();
        largestTriangleArea.largestTriangleArea(points);
    }

    public double largestTriangleArea(int[][] points) {
        double maxArea = 0;
        int length = points.length;
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {
                    //1/2 * (x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2))
                    double area = Math.abs(0.5 * (points[i][0] * (points[j][1] - points[k][1]) + points[j][0] * (points[k][1] - points[i][1]) + points[k][0] * (points[i][1] - points[j][1])));
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}
