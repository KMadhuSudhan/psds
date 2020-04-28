package com.madhu.psds.arrays;

//https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
//862. Shortest Subarray with Sum at Least K

public class ShortestSubarrayWithSumAtLeastK {
    public static void main(String[] args) {
        int[] nums = {48,99,37,4,-31};
        ShortestSubarrayWithSumAtLeastK shortestSubarrayWithSumAtLeastK = new ShortestSubarrayWithSumAtLeastK();
        System.out.println(shortestSubarrayWithSumAtLeastK.shortestSubarray(nums, 140));
    }

    public int shortestSubarray(int[] A, int K) {
        int size =  shortestSubarray(A,K,false);
        if(size == -1) {
            size =  shortestSubarray(A,K,true);
        }
        return size;
     }

    public int shortestSubarray(int[] A, int K,boolean includeNegative) {
        int size=0, minSize = Integer.MAX_VALUE,length = A.length, sum = 0, low = 0, i = 0;
        int maxSum = 0;
        while (i < length) {
            if(sum>=K && size == 1) return 1;
            if((sum>=K && low  < length)) {
                sum -= A[low];
                maxSum = Math.max(sum,maxSum);
                minSize = Math.min(minSize,size);
                low++;
                size--;
            } else  {
                if(A[i] < 0 && includeNegative) {
                    sum = 0;
                    size = 0;
                    minSize = Integer.MAX_VALUE;
                    i++;
                } else {
                    sum+= A[i++];
                    maxSum = Math.max(sum,maxSum);
                    size++;
                }
            }
        }
        return maxSum<K  ? -1 : size;
    }

}
