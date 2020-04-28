package com.madhu.psds.bits;

import java.util.ArrayList;
import java.util.List;

public class AddingTwoNegabinaryNumbers {
    public static void main(String[] args) {
        AddingTwoNegabinaryNumbers addingTwoNegabinaryNumbers = new AddingTwoNegabinaryNumbers();
        int[] num1 = {0};
        int[] num2 = {1,1};
        addingTwoNegabinaryNumbers.addNegabinary(num1,num2);
    }
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int num1 = getNumber(arr1);
        int num2 = getNumber(arr2);
        int num = num1+num2;
        int[] binary = getBinaryNumber(Math.abs(num));
        return binary;
    }

    int getNumber(int[] arr) {
        int length = arr.length,j=length-1,base=1,num=0;
        while (j>=0) {
            num+=arr[j]*base;
            base = base*-2;
            j--;
        }
        return num;
    }

    int[] getBinaryNumber(int num) {
        List<Integer> list = new ArrayList<>();
        while (num!=0) {
            int rem = num%2;
            list.add(rem);
            num/=2;
        }
        int size = list.size();
        int[] binaryNumber = new int[size];
        for (int i=size-1;i>=0;i--) {
            binaryNumber[size-i-1] = list.get(i);
        }
        return binaryNumber;
    }
}
