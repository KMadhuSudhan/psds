package com.madhu.psds.arrays;
//https://leetcode.com/problems/random-pick-with-weight/
//528. Random Pick with Weight

import java.util.concurrent.ThreadLocalRandom;

public class RandomPickWithWeight {

    int[] sum;
    public RandomPickWithWeight(int[] w) {
        for(int i = 1; i < w.length; i++) {
            w[i] = w[i - 1] + w[i];
        }
        sum = w;
    }

    public int pickIndex() {
        int random = ThreadLocalRandom.current().nextInt(1, sum[sum.length - 1] + 1);
        return binarySearch(random, 0, sum.length - 1);
    }

    int binarySearch(int target, int start, int end) {
        int mid = (start + end) / 2;
        int rangeStart = mid == 0 ? 1 : sum[mid - 1] + 1;
        int rangeEnd = sum[mid];

        if(target >= rangeStart && target <= rangeEnd) {
            return mid;
        }

        if(target < rangeStart) {
            return binarySearch(target, start, mid - 1);
        }

        return binarySearch(target, mid + 1, end);
    }

}
