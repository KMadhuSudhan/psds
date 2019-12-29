package com.madhu.psds.geometry;

public class MinimumTime {
    public static void main(String args[]) {
        int[][] points = new int[][]{{1, 1}, {3, 4}, {-1, 0}};
        MinimumTime minimumTime = new MinimumTime();
        System.out.print(minimumTime.minTimeToVisitAllPoints(points));
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        for(int i = 0; i < points.length - 1; i++)
            time += Math.max( Math.abs(points[i][0] - points[i+1][0]), Math.abs(points[i][1] - points[i+1][1]));
        return time;
    }
}
