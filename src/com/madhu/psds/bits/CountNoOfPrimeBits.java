package com.madhu.psds.bits;


public class CountNoOfPrimeBits {
    public static void main(String[] args) {
        CountNoOfPrimeBits countNoOfPrimeBits = new CountNoOfPrimeBits();
        System.out.println(countNoOfPrimeBits.countPrimeSetBits(6,10));
    }

    public int countPrimeSetBits(int L, int R) {
        int primeCount = 0;
        while (L<=R) {
            int bitCount = Integer.bitCount(L);
            if(isPrime(bitCount)) {
                primeCount++;
            }
            L++;
        }
        return primeCount;
    }

    public boolean isPrime(int n) {
        if(n==1 || n==0) return false;
        if(n==2 || n==3) return true;
        for (int i=2;i*i< n;i++){
            for (int j = i*i; j < i;j+=i){
                if(n%j == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
