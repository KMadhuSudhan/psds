package com.madhu.psds.arrays;

import java.util.HashSet;
import java.util.Set;

public class ArrayNesting {
    public static void main(String[] args) {
        ArrayNesting arrayNesting = new ArrayNesting();
        int[] nums = {5,4,0,3,1,6,2};
        System.out.println(arrayNesting.arrayNesting(nums));
    }
    public int arrayNesting(int[] nums) {
        int length = nums.length;
        int maxCount = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<length;i++) {
            int num = nums[i];
            int count = 0;
            while (!set.contains(num)) {
                count++;
                set.add(num);
                num = nums[num];
            }
            maxCount = Math.max(maxCount,count);
        }
        return maxCount;
    }
}
