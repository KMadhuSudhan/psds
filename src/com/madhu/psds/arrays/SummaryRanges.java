package com.madhu.psds.arrays;
//https://leetcode.com/problems/summary-ranges/submissions/
//228. Summary Ranges

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        SummaryRanges summaryRanges = new SummaryRanges();
        System.out.println(summaryRanges.summaryRangesStart(nums));
    }

    public List<String> summaryRangesStart(int[] nums) {
        int length = nums.length;
        List<String> result = new ArrayList();
        if(length == 0) return result;
        int start = nums[0];
        for(int i=1;i<length;i++) {
            if((nums[i]-1) !=nums[i-1]){
                if(start == nums[i-1]) {
                    result.add("" + nums[i-1]);
                } else {
                    result.add(start + "->" + nums[i-1]);
                }
                start = nums[i];
            }
        }
        if(start == nums[length-1]){
            result.add("" + nums[length-1]);
        } else {
            result.add(start + "->" + nums[length-1]);
        }
        return result;
    }
}
