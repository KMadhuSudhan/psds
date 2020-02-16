package com.madhu.psds.arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {-2,-1};
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
//        Arrays.binarySearch()
        int length = nums.length;
        if(length == 0) return 0;
        int[] subseq = new int[length];
        for(int i=0;i<length;i++) {
            subseq[i] = 1;
        }
        int j =0;
        int i;
        int max = 1;
        for(i=1;i<length;i++) {
            while(j<i) {
                if(nums[i] > nums[j]) {
                    subseq[i] = Math.max(subseq[i],subseq[j]  + 1);
                    max = Math.max(max,subseq[i]);
                }
                j++;
            }
            j = 0;
        }
        return max;
    }
}
