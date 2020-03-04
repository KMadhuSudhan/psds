package com.madhu.psds.arrays;

public class MaxPrimeSubArray {
    public static void main(String[] args) {
        String length = "4" ;
        String[] numbers = {"6","2","3","4"};
        int arrLength = Integer.parseInt(length);
        int max = 0;
        int maxSoFar = 0;
        for(int i=0;i<arrLength;i++) {
            boolean isPrime = isPrime(Integer.parseInt(numbers[i]));
            if(isPrime) {
                max = max + 1;
            } else {
                if(max > 0) max = max -1;
            }
            if(maxSoFar < max) maxSoFar = max;
        }
        if(maxSoFar == 0) {
            System.out.print(-1);
        } else {
            System.out.print(maxSoFar);
        }
    }
    private static boolean isPrime(int n) {
        if(n == 2) return true;
        for(int i=2;i*i<n;i++) {
            if(n%2 == 0) return true;
        }
        return false;
    }
}
