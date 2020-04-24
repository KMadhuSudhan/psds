package com.madhu.psds.number;
//https://leetcode.com/problems/airplane-seat-assignment-probability/submissions/
//1227. Airplane Seat Assignment Probability

public class AirplaneSeatAssignmentProbability {
    public static void main(String[] args) {
        AirplaneSeatAssignmentProbability airplaneSeatAssignmentProbability = new AirplaneSeatAssignmentProbability();
        airplaneSeatAssignmentProbability.nthPersonGetsNthSeat(1);
    }

    public double nthPersonGetsNthSeat(int n) {
        if(n==1) return 1.0;
        return 0.5;
    }
}
