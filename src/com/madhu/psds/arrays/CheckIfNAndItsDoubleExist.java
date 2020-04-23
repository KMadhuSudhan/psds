package com.madhu.psds.arrays;
//https://leetcode.com/problems/check-if-n-and-its-double-exist/
//1346. Check If N and Its Double Exist

public class CheckIfNAndItsDoubleExist {
    public static void main(String[] args) {
        CheckIfNAndItsDoubleExist checkIfNAndItsDoubleExist = new CheckIfNAndItsDoubleExist();
        int[] nums = {10,2,5,3};
        checkIfNAndItsDoubleExist.checkIfExist(nums);
    }
    public boolean checkIfExist(int[] arr) {
        for(int i=0;i<arr.length-1;i++) {
            for(int j=i+1;j<arr.length;j++) {
                if(arr[i]*2 == arr[j] || arr[j]*2 == arr[i]) return true;
            }
        }
        return false;
    }
}
