package com.madhu.psds.strings;
//https://leetcode.com/problems/maximum-score-after-splitting-a-string/
//1422. Maximum Score After Splitting a String

public class MaxScoreAfterSplitting {
    public static void main(String[] args) {
        MaxScoreAfterSplitting maxScoreAfterSplitting = new MaxScoreAfterSplitting();
        String s = "00";
        System.out.println(maxScoreAfterSplitting.maxScore(s));
    }
    public int maxScore(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length,score = 0;
        int[] zerosOnesCount = new int[2];

        for(int i=0;i<length;i++) {
            zerosOnesCount[chars[i] - '0']++;
        }
        int leftOnes = 0,leftZeros=0;
        for (int i=0;i<length-1;i++) {
            if(chars[i] == '0' ) {
                leftZeros++;
            } else {
                leftOnes++;
            }
            int rightOnes = zerosOnesCount[1] - leftOnes;
            score = Math.max(score,leftZeros + rightOnes);
        }
        return score;
    }
}
