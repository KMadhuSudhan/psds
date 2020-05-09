package com.madhu.psds.arrays;

public class KConcatenationMaximumSum {

    public int kConcatenationMaxSum(int[] arr, int k) {
        int MOD = 1000000007;
        long totalsum = 0;
        long maxSum = 0;
        long currSum = 0;
        long prefixSumMax = 0;
        long result = 0;

        for(int i=0; i<arr.length; i++){
            totalsum = totalsum + arr[i];
            currSum = currSum + arr[i];
            prefixSumMax = Math.max(prefixSumMax,totalsum);
            if(currSum < 0) currSum = 0;
            maxSum = Math.max(maxSum,currSum);
        }
        // if currSum == 0, totalsum is guranteed to be negative but the converse is not true
        if(currSum == 0){
            result = maxSum;
        }else{
            if(totalsum >=0){
                if(k < 2) result =  maxSum;
                else result = Math.max(maxSum,totalsum*(k-2)+currSum+prefixSumMax);
            }
            else
                result = Math.max(maxSum,prefixSumMax+currSum);
        }
        return (int)(result%MOD);
    }
}
