package com.madhu.psds.number;
//https://leetcode.com/problems/broken-calculator/
//991. Broken Calculator

public class BrokenCalculator {

    public static void main(String[] args) {
        BrokenCalculator brokenCalculator = new BrokenCalculator();
        brokenCalculator.brokenCalc(2,3);
    }
    public int brokenCalc(int X, int Y) {
        int count =0;
        while(Y>X) {
            if(Y%2==1) {
                Y+=1;
            } else {
                Y/=2;
            }
            count++;
        }
        return count + X-Y;
    }
}
