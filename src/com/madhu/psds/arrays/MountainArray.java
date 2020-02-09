package com.madhu.psds.arrays;

public class MountainArray {
    public static void main(String[] args) {
        int[] a = {0, 3, 2, 1};
        MountainArray mountainArray = new MountainArray();
        mountainArray.validMountainArray(a);
    }

    //version 0
    public boolean validMountainArray(int[] A) {
        int length = A.length;
        if(length == 0 || length == 1) return false;
        if(length == 2) return A[1] > A[0];
        boolean isValid = true;
        boolean increasingOrder = true;
        boolean  isItContiNousDecrease = A[1] < A[0];
        for (int i = 1; i < length; i++) {
            if(increasingOrder == true && A[i] < A[i-1]) {
                increasingOrder = false;
            }
            if(isItContiNousDecrease && A[i] > A[i -1]) isItContiNousDecrease = false;
            if (A[i-1] == A[i]) return false;
            isValid = increasingOrder && A[i] > A[i-1];
            if(isValid) continue;
            isValid = increasingOrder == false && A[i] < A[i-1];
            if(isValid == false) return false;
        }
        return isValid && increasingOrder == false && isItContiNousDecrease == false;
    }
    //version  1
    public boolean validMountainArrayImproved(int[] A) {
        int length = A.length;
        if(length < 3) return false;
        int i =1;
        while (i<length && A[i] > A[i-1])
            i++;
        if(i == 1 || i == length) return false;
        while (i<length && A[i-1] > A[i])
            i++;
        if(i == length) return true;
        return false;
    }
}
