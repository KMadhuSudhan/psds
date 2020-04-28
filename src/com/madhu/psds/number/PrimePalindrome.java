package com.madhu.psds.number;
//https://leetcode.com/problems/prime-palindrome/submissions/
//866. Prime Palindrome

public class PrimePalindrome {
    public static void main(String[] args) {
        PrimePalindrome primePalindrome = new PrimePalindrome();
        primePalindrome.primePalindrome(10000200);
    }
    public int primePalindrome(int N) {
        if(N<2) return 2;
        while(true) {
            if(N%2==0 && N>2){
                ++ N;
            }

            if (N == reverse(N) && isPrime(N))
                return N;
            N++;
            // all 8 digit palindromes are not prime
            if (10_000_000 < N && N < 100_000_000)
                N = 100_000_000;
        }
    }

    private boolean isPrime(int n)
    {
        if(n<2)
            return true;
        for(int i=2;i*i<=n;i++)
            if(n%i==0)
                return false;
        return true;
    }

    private int reverse(int n)
    {
        int num = 0;
        while(n!=0) {
            int r = n%10;
            num = num*10 + r;
            n/=10;
        }
        return num;
    }

}
