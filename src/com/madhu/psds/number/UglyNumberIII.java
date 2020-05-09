package com.madhu.psds.number;
//https://leetcode.com/problems/ugly-number-iii/
//1201. Ugly Number III

public class UglyNumberIII {
    public static void main(String[] args) {
        UglyNumberIII uglyNumberIII = new UglyNumberIII();
        System.out.println(uglyNumberIII.nthUglyNumber(4, 2, 3, 4));
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        long  min=Math.min(Math.min(a,b),c);
        long r=1;
        long p=min*n;

        while(r<=p){
            long m=r+((p-r)/2);
            long s=count(m,a,b,c);
            if(s==n)return (int)Math.max(Math.max(m/a*a,m/b*b),m/c*c);
            else if(s<n) r=m+1;
            else p=m-1;

        }
        throw new IllegalArgumentException("n is too large");
    }

    long count(long N,int A,int B,int C){
        return N/A+N/B+N/C-countIntersection(N,A,B,A)-countIntersection(N,A,C,A)-countIntersection(N,B,C,B)+countIntersection(N,A,B,C);
    }

    // |SA ∩ SB ∩ SC|, when A==C,|SA ∩ SB ∩ SC| = |SA ∩ SB|
    long countIntersection(long N,int A,int B,int C){
        int Bx=B/gcd(A,B);
        int Cx=C/gcd(A,C);
        int Dx=gcd(Bx,Cx);
        long F=(long)A*Bx*Cx;
        return Dx*N/F;
    }

    int gcd(int x,int y){
        return y==0?x:gcd(y,x%y);
    }
}
