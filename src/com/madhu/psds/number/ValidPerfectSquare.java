package com.madhu.psds.number;
//https://leetcode.com/problems/valid-perfect-square/
//367. Valid Perfect Square

public class ValidPerfectSquare {
    public static void main(String[] args) {
        int n = 9;
        ValidPerfectSquare validPerfectSquare = new ValidPerfectSquare();
        System.out.println(validPerfectSquare.isPerfectSquare(n));
    }
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        if(num <= 0) return false;

        return find(num, 0, num);
    }

    boolean find(long tgt, int l, int h)
    {
        while(l <= h)
        {
            int mid = (l+h)/2;
            long sq = (long)mid*mid;
            if(sq == tgt) return true;
            else if(sq > tgt) h = mid-1;
            else l = mid+1;
        }
        return false;
    }
}
