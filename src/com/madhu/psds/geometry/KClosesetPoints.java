package com.madhu.psds.geometry;

import java.util.*;
//https://leetcode.com/problems/k-closest-points-to-origin/
//973. K Closest Points to Origin

public class KClosesetPoints {
    public static void main(String[] args) {
        int[][] points = {{-5, 4}, {-6, -5}, {4, 6}};
        KClosesetPoints kClosesetPoints = new KClosesetPoints();
        kClosesetPoints.kClosest(points, 1);
    }

    public int[][] kClosest(int[][] points, int K) {
        return new int[][]{{}};
    }
}
