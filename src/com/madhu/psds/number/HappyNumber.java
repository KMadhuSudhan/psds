package com.madhu.psds.number;
//https://leetcode.com/problems/happy-number/
//202. Happy Number

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(19));
    }

    public boolean isHappy(int n) {
        int sum = 0;
        while (n!=0) {
            sum+=n%10 * n%10;
            n=n/10;
        }
        if(set.contains(sum)) return false;
        set.add(sum);
        return sum == 1 || isHappy(n);
    }
}
