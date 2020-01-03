package com.madhu.psds.number;

public class Sqrt {
    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.mySqrt(4));
    }

    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x; //base case

        int low = 1;
        int high = x/2;

        while (low <= high) {
            int mid = low + (high-low)/2; //avoid int overflow
            int r = x/mid; //compute this to avoid overflow
            if (r == mid) return mid; //compare mid*mid to x
            else if (r < mid) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return high;
    }
}
