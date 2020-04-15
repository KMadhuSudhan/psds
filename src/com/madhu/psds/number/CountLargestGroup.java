package com.madhu.psds.number;
//https://leetcode.com/problems/count-largest-group/
//1399. Count Largest Group


import java.util.Arrays;

public class CountLargestGroup {
    public static void main(String[] args) {
        int n=13;
        CountLargestGroup countLargestGroup = new CountLargestGroup();
        System.out.println(countLargestGroup.countLargestGroup(n));
    }
    public int countLargestGroup(int n) {
        int[] arr = new int[37];
        for (int i=1;i<=n;i++) {
            arr[sum(i)]++;
        }
        Arrays.sort(arr);
        int freq = arr[36];
        int maxCount = 1;
        int end = 35;
        while (end>=0 && arr[end] == freq) {
            maxCount++;
            end--;
        }
        return maxCount;
    }

    int sum(int n) {
        int sum =0;
        while (n!=0) {
            int reminder = n%10;
            sum +=reminder;
            n/=10;
        }
        return sum;
    }
}
