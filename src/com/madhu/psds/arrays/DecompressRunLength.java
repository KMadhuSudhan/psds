package com.madhu.psds.arrays;
//https://leetcode.com/problems/decompress-run-length-encoded-list/
//1313. Decompress Run-Length Encoded List

import java.util.ArrayList;
import java.util.List;

public class DecompressRunLength {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        DecompressRunLength decompressRunLength = new DecompressRunLength();
        decompressRunLength.decompressRLElist(nums);
    }

    public int[] decompressRLElist(int[] nums) {
        int length = nums.length;
        if(length<2) return new int[]{};
        List<Integer> result = new ArrayList<>();
        int i=0;
        while (i<length) {
            int freq = nums[i];
            int val = nums[i+1];
            while (freq-- > 0) {
                result.add(val);
            }
            i = i+2;
        }
        int size = result.size();
        int[] arrResult = new int[size];
        int k =0;
        for (int element: result) {
            arrResult[k++] = element;
        }
        return arrResult;
    }
}
