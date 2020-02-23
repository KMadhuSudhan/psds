package com.madhu.psds.number;
//https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/submissions/
//1342. Number of Steps to Reduce a Number to Zero

public class NoStepsToReduceZero {

    public int numberOfSteps (int num) {
        int count=0;
        while(num!=0) {
            if(num%2 == 0) {
                num = num/2;
            } else {
                num--;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        NoStepsToReduceZero noStepsToReduceZero = new NoStepsToReduceZero();
        int num=14;
        noStepsToReduceZero.numberOfSteps(num);
    }
}
