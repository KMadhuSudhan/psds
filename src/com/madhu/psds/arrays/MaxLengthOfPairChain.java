package com.madhu.psds.arrays;
//https://leetcode.com/problems/maximum-length-of-pair-chain/
//646. Maximum Length of Pair Chain

import java.util.*;

public class MaxLengthOfPairChain {
    public static void main(String[] args) {
//        int[][] pairs = {
//                {9,10},
//                {9,10},
//                {4,5},
//                {-9,-3},
//                {-9,1},
//                {0,3},
//                {6,10},
//                {-5,-4},
//                {-7,-6}
//        };
        int[][] pairs = {
                {1,2},
                {2,3},
                {3,4}
        };
        MaxLengthOfPairChain maxLengthOfPairChain = new MaxLengthOfPairChain();
        System.out.println(maxLengthOfPairChain.findLongestChain(pairs));
    }
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] ans = new int[pairs.length];
        Arrays.fill(ans,1);
        int result = 0;
        for (int i=1;i<pairs.length;i++) {
            for (int j=0;j<i;j++) {
                if(pairs[i][0] > pairs[j][1]) {
                    ans[i] = Math.max(ans[i],1+ ans[j]);
                    result = Math.max(ans[i],result);
                }
            }
        }

        return result;
    }
}
