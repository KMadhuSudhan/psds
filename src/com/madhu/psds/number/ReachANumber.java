package com.madhu.psds.number;
//https://leetcode.com/problems/reach-a-number/
public class ReachANumber {
    public static void main(String[] args) {
        ReachANumber reachANumber = new ReachANumber();
        reachANumber.reachNumber(3);
    }
    public int reachNumber(int target) {
        target = Math.abs(target);
        int step = 0;
        int sum = 0;
        while (sum < target) {
            step++;
            sum += step;
        }
        while ((sum - target) % 2 != 0) {
            step++;
            sum += step;
        }
        return step;
    }
}
