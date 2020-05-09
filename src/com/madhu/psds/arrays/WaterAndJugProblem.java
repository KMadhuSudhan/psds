package com.madhu.psds.arrays;
//https://leetcode.com/problems/water-and-jug-problem/
//365. Water and Jug Problem

public class WaterAndJugProblem {

    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) {
            return true;
        }
        if (x + y < z) {
            return false;
        }
        return z % gcd(x, y) == 0;
    }

    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x%y);
    }
}
