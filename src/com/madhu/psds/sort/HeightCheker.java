package com.madhu.psds.sort;

public class HeightCheker {
    public static void main(String[] args) {
        int[] heights = new int[]{1,1,4,2,1,3};
        System.out.println(heightChecker(heights));
    }
    private static int heightChecker(int[] heights) {
        int count = 0;
        int length = heights.length;
        int i,j;
        for(i=0;i<length;i++) {
            for(j=1;j<length-i;j++) {
                if(heights[j] < heights[j-1]) {
                    int temp = heights[j-1];
                    heights[j-1] = heights[j];
                    heights[j] = temp;
                    count++;
                }
            }
        }
        return count;
    }
}
