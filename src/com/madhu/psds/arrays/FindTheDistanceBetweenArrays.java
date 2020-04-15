package com.madhu.psds.arrays;
//https://leetcode.com/problems/find-the-distance-value-between-two-arrays
//1385. Find the Distance Value Between Two Arrays

public class FindTheDistanceBetweenArrays {
    public static void main(String[] args) {
        int[] arr1 = {4,5,8};
        int[] arr2 = {10,9,1,8};
        FindTheDistanceBetweenArrays findTheDistanceBetweenArrays = new FindTheDistanceBetweenArrays();
        findTheDistanceBetweenArrays.findTheDistanceValue(arr1,arr2,2);

    }
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int i=0;i<arr1.length;i++) {
            for (int j=0;j<arr2.length;j++) {
                if(arr1[i]!=arr2[j] && Math.abs(arr1[i] - arr2[j]) <= d)  count++;
            }
        }
        return count;
    }
}
