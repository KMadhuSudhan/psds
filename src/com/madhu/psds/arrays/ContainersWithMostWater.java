package com.madhu.psds.arrays;
//https://leetcode.com/problems/container-with-most-water/
//11. Container With Most Water

public class ContainersWithMostWater {
    public static void main(String[] args) {
        ContainersWithMostWater containersWithMostWater = new ContainersWithMostWater();
        int[] nums = {1,8,6,2,5,4,8,3,7};
        containersWithMostWater.maxArea(nums);
    }
    public int maxArea(int[] height) {
        int low=0,high=height.length-1;
        int area=0;
        while(low<high)
        {
            if(height[low]<height[high])
            {
                if((height[low]*(high-low))>area)
                    area=(height[low]*(high-low));
                low++;
            }
            else
            {
                if((height[high]*(high-low))>area)
                    area=(height[high]*(high-low));
                high--;
            }
        }
        return area;
    }
}
