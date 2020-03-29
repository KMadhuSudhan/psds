package com.madhu.psds.strings;
//https://leetcode.com/problems/minimum-swaps-to-make-strings-equal
//1247. Minimum Swaps to Make Strings Equal

public class MinimumSwaps {
    public static void main(String[] args) {
        MinimumSwaps minimumSwaps = new MinimumSwaps();
        minimumSwaps.minimumSwap("xx","yy");
    }

    public int minimumSwap(String s1, String s2) {
        int a=0,b=0,ans=0,n=s1.length();
        char[] s1Char = s1.toCharArray();
        char[] s2char = s2.toCharArray();

        for(int i=0; i<n; i++)
            if(s1Char[i] != s2char[i]) {
                if(s1Char[i] =='x' )
                    a++;
                else
                    b++;
            }
        ans += (a/2 + b/2);
        a%=2;
        b%=2;
        return (a==b ? (a==1 ?  ans+2: ans) : -1);
    }
}
