package com.madhu.psds.clock;
//https://leetcode.com/problems/angle-between-hands-of-a-clock/
//1344. Angle Between Hands of a Clock

public class AngleBetweenHandsOfClock {
    public static void main(String[] args) {
        AngleBetweenHandsOfClock angleBetweenHandsOfClock = new AngleBetweenHandsOfClock();
        angleBetweenHandsOfClock.angleClock(12,30);
    }
    public double angleClock(int hour, int minutes) {
        double hAngle = ((double)hour%12.0) * 30.00;
        hAngle += (((double)minutes/60.0) * 30.00);

        double mAngle = 6.0 * (double)minutes;

        return Math.min(Math.abs(hAngle - mAngle), 360.0 - Math.abs(mAngle - hAngle));
    }
}
