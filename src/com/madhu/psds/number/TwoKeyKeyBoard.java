package com.madhu.psds.number;
//https://leetcode.com/problems/2-keys-keyboard/submissions/
//650. 2 Keys Keyboard

public class TwoKeyKeyBoard {

    public int minSteps(int n) {
        int num = 1;
        int steps = 0;
        int cop = 1;
        while (num < n)
        {
            if (n % num == 0)
            {
                steps += 2;
                cop = num;
                num *= 2;
            }
            else
            {
                steps++;
                num += cop;
            }
        }
        return steps;
    }
}
