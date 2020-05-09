package com.madhu.psds.number;
//https://leetcode.com/problems/valid-perfect-square/
//367. Valid Perfect Square

public class ValidPerfectSquare {
    public static void main(String[] args) {
        int n = 855;
        ValidPerfectSquare validPerfectSquare = new ValidPerfectSquare();
        System.out.println(validPerfectSquare.isPerfectSquare(n));
    }

    public boolean isPerfectSquare(int num) {
        int lastDigit = num%10;
        boolean issqureEnds = lastDigit == 0 || lastDigit == 1 || lastDigit == 4 ||  lastDigit == 5 || lastDigit == 6 || lastDigit == 9;
        if(issqureEnds == false) return false;
        int sum=getSum(num);
        while(sum>9) {
            sum = getSum(sum);
        }
        return sum == 1 || sum == 4 || sum == 7 || sum == 9;
    }

    int getSum(int n) {
        int sum= 0;
        while(n>0) {
            sum+=n%10;
            n/=10;
        }
        return sum;
    }

//    public boolean isPerfectSquare(int num) {
//        if(num == 1) return true;
//        if(num <= 0) return false;
//
//        return find(num, 0, num);
//    }
//
//    boolean find(long tgt, int l, int h)
//    {
//        while(l <= h)
//        {
//            int mid = (l+h)/2;
//            long sq = (long)mid*mid;
//            if(sq == tgt) return true;
//            else if(sq > tgt) h = mid-1;
//            else l = mid+1;
//        }
//        return false;
//    }
}
