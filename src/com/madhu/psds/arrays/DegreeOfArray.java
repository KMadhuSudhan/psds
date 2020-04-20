package com.madhu.psds.arrays;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfArray {
    public static void main(String[] args) {
        DegreeOfArray degreeOfArray = new DegreeOfArray();
        int[] arr = {1, 2, 2, 3, 1};
        degreeOfArray.findShortestSubArray(arr);
    }
    public int findShortestSubArray(int[] nums) {
        int max = 0;
        int length = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<length;i++) {
            int count = map.getOrDefault(nums[i],0);
            count++;
            map.put(nums[i],count);
            max = Math.max(max,count);
            if(max < count) {
                max = count + 1;
            }
        }

        return max;
    }
}
