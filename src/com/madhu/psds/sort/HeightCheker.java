package com.madhu.psds.sort;

public class HeightCheker {
    public static void main(String[] args) {
        int[] heights = new int[]{1, 1, 4, 2, 1, 3};
        HeightCheker heightCheker = new HeightCheker();
        System.out.println(heightCheker.heightChecker(heights));
    }

    public int heightChecker(int[] heights) {
        int count = 0;
        int length = heights.length;
        int i, j;
        for (i = 0; i < length - 1; i++) {
            boolean flag = false;
            for (j = 0; j < length - i - 1; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j + 1];
                    heights[j + 1] = heights[j];
                    heights[j] = temp;
                    count++;
                    flag = true;
                }
            }
            if (flag == false) break;
        }
        return count - 1;
    }
}
