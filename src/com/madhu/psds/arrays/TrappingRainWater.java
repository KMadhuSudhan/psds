package com.madhu.psds.arrays;

public class TrappingRainWater {
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (left < right) {
            if(height[left] < height[right]) {
                if(leftMax < height[left]) {
                    leftMax = height[left];
                }
                result += leftMax - height[left];
                left++;
            } else {
                if(rightMax < height[right]) {
                    rightMax = height[right];
                }
                result += rightMax - height[right];
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappingRainWater.trap(height));
    }
}
