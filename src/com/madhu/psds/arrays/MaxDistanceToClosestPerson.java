package com.madhu.psds.arrays;
//https://leetcode.com/problems/maximize-distance-to-closest-person/
//849. Maximize Distance to Closest Person

public class MaxDistanceToClosestPerson {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1};
        MaxDistanceToClosestPerson maxDistanceToClosestPerson = new MaxDistanceToClosestPerson();
        System.out.println(maxDistanceToClosestPerson.maxDistToClosest(arr));
    }

    public int maxDistToClosest(int[] seats) {
        int dist, zero, i;
        int seatsSize = seats.length;
        dist = 0;
        while (seats[dist] == 0)
            ++dist;
        zero = 0;
        for (i = dist + 1; i < seatsSize; ++i)
            if (seats[i] == 0) {
                ++zero;
            } else {
                dist = Math.max(dist, (zero + 1) / 2);
                zero = 0;
            }
        return Math.max(dist, zero);
    }
}
