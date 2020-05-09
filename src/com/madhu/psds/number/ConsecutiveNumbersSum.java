package com.madhu.psds.number;
//https://leetcode.com/problems/consecutive-numbers-sum/
//829. Consecutive Numbers Sum

public class ConsecutiveNumbersSum {
    public static void main(String[] args) {
        ConsecutiveNumbersSum consecutiveNumbersSum = new ConsecutiveNumbersSum();
        consecutiveNumbersSum.consecutiveNumbersSum(5);
    }
    public int consecutiveNumbersSum(int N) {
        int ans=0;
        for(int k=1;2*N-k*(k+1) >= 0;k++)
        {
            int sum=2*N-k*(k+1);
            if(sum%(2*k)==0)
                ans++;
        }
        return ans;
    }
}
