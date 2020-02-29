package com.madhu.psds.arrays;
//https://leetcode.com/problems/reaching-points/
//780. Reaching Points

public class ReachingPoints {
    public static void main(String[] args) {
        ReachingPoints reachingPoints = new ReachingPoints();
        System.out.println(reachingPoints.reachingPoints(3,3,12,9));
    }

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if( sx == tx && sy == ty) return true;
        if( sx > tx || sy > ty) return false;
        if(sx == 0 && sy == 0 && (tx!=0 || ty!=0)) return false;
        while(sx < tx || sy < ty ) {
//            while(sx < tx) {
//                sx = sx + sy;
//            }
//            while(sy < ty) {
//                sy = sy + sx;
//            }
            if(sx < tx && sx <= sy) {
                sx = sx + sy;
            } else if(sy < ty && sy <= sx) {
                sy = sy + sx;
            }
            if(sx == tx && sy == ty) {
                return true;
            }
        }
        return sx == tx && sy == ty;
    }
}
