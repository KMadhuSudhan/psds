package com.madhu.psds.arrays;

public class NextGreaterElement {
    public static void main(String[] args) {

    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int num1Length = nums1.length;
        int num2Length = nums2.length;
        int[] minElements = new int[num1Length];
        for(int i=0;i<num1Length;i++) {
            int nextMajarityElement = -1;
            boolean foundElement = false;
            for(int j=0;j<num2Length;j++) {
                if(nums1[i] == nums2[j]) {
                    foundElement = true;
                    continue;
                }
                if(foundElement == false) {
                    continue;
                }
                if(nextMajarityElement == -1 && nums1[i] < nums2[j] ) {
                    nextMajarityElement = nums1[j];
                }
            }
            minElements[i] = nextMajarityElement;
        }
        return minElements;
    }
}
