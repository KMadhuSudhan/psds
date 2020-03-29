package com.madhu.psds.arrays;
//https://leetcode.com/problems/find-the-town-judge/
//997. Find the Town Judge

public class FindTheTownJudge {
    public static void main(String[] args) {
        int[][] trust = {
                {1,2},
        };
        FindTheTownJudge findTheTownJudge = new FindTheTownJudge();
        findTheTownJudge.findJudge(2,trust);
    }

    public int findJudge(int N, int[][] trust) {
        if(trust.length == 0) {
            return N == 1 ? 1 : -1;
        }
        int[] in = new int[N+1];
        int[] out = new int[N+1];
        for(int i=0;i<trust.length;i++) {
            in[trust[i][1]]++;
            out[trust[i][0]]++;
        }
        for(int i=0;i<in.length;i++) {
            if(in[i] == N-1 && out[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
