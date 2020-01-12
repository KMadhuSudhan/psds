package com.madhu.psds.geometry;

import java.util.Arrays;

public class LargestPerimeterTriangle {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,1};
        LargestPerimeterTriangle largestPerimeterTriangle = new LargestPerimeterTriangle();
        largestPerimeterTriangle.largestPerimeter(array);
    }

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int length = A.length;
        if (length < 3) return 0;
        for (int i = length - 1; i >= 2; i--) {
            if (isTriangle(A[i], A[i - 1], A[i - 2])) {
                return (A[i] + A[i - 1] + A[i - 2]);
            }
        }
        return 0;
    }

    public boolean isTriangle(int a, int b, int c) {
        if (a + b > c && c + b > a && c + a > b) {
            return true;
        } else {
            return false;
        }
    }
}
