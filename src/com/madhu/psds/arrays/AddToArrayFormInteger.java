package com.madhu.psds.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayFormInteger {
    public static void main(String[] args) {
        int[] A = {0};
        int n = 10000;
        AddToArrayFormInteger addToArrayFormInteger = new AddToArrayFormInteger();
        addToArrayFormInteger.addToArrayForm(A, n);
    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        int N = A.length;
        int cur = K;
        List<Integer> ans = new ArrayList();

        int i = N;
        while (--i >= 0 || cur > 0) {
            if (i >= 0)
                cur += A[i];
            ans.add(cur % 10);
            cur /= 10;
        }
        Collections.reverse(ans);
        return ans;
    }
}
