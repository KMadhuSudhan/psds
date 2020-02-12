package com.madhu.psds.arrays;

import java.util.ArrayList;
import java.util.List;

public class AddToArrayFormInteger {
    public static void main(String[] args) {
        int[] A = {0};
        int n = 10000;
        AddToArrayFormInteger addToArrayFormInteger = new AddToArrayFormInteger();
        addToArrayFormInteger.addToArrayForm(A,n);
    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList<>();
        int length = A.length;
        int i = length - 1;
        int carry = 0;
        int sum;
        while (K > 0 && i >= 0) {
            int rem = K % 10;
            sum = carry + A[i] + rem;
            if (sum == 10) {
                A[i] = 0;
                carry = 1;
            } else if (sum > 10) {
                A[i] = sum - 10;
                carry = 1;
            } else {
                A[i] = sum;
                carry = 0;
            }
            i--;
            K = K / 10;
        }
        while (K > 0) {
            int rem = K % 10;
            result.add(rem);
            K = K / 10;
        }
        while (i >= 0 && carry!=0) {
            sum  = A[i] + carry;
            if (sum == 10) {
                A[i] = 0;
                carry = 1;
            } else if (sum > 10) {
                A[i] = sum - 10;
                carry = 1;
            } else {
                A[i] = sum;
                carry = 0;
            }
            i--;
        }
        if (i < 0) i++;
        if (carry != 0) {
            result.add(1);
        }
        if (K == 0 && i >= 0) {
            for (int j = 0; j < length; j++) {
                result.add(A[j]);
            }
        }
        return result;
    }
}
