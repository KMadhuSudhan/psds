package com.madhu.psds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i=0, j=0;

        while(i<nums1.length && j<nums2.length) {

            if(nums1[i] == nums2[j]) {
                list.add(nums1[i++]);
                j++;
            }else if(nums1[i] < nums2[j]) {
                i++;
            }else {
                j++;
            }

        }

        int output[] = new int[list.size()];
        i=0;
        for(int num: list) {
            output[i++] = num;
        }

        return output;
    }
}
