//https://leetcode.com/problems/valid-triangle-number/submissions/
//611. Valid Triangle Number

package com.madhu.psds.arrays;
import java.util.Arrays;
public class ValidTriangleNumber {
    static int  counter = 0;
    public static void main(String[] args) {
        int[] nums = {2,2,3,4};
        ValidTriangleNumber validTriangleNumber = new ValidTriangleNumber();
        validTriangleNumber.triangleNumber(nums);
    }
    public int triangleNumber(int[] nums) {
        if(nums.length<3)
            return 0;
        Arrays.sort(nums);
        int length = nums.length;
        int count = 0;
        for(int i=2;i<length;i++) {
            int left = 0;
            int right = i-1;
            while(left<right) {
                if((nums[left] + nums[right]) <= nums[i]){
                    left++;
                } else {
                    count += right - left;
                    right--;
                }
            }
        }
        return count;
    }
}


//[16,70,16,36,17,39,44,72,25,88,18,22,20,84,18,66,71,74,87,59,48,91,52,15,92,29,85,21,10,34,86,68,10,27,3,42,49,48,18,15,6,39,61,28,19,52,60,8,37,32,71,82,54,38,47,33,10,64,52,71,39,63,64,79,86,47,16,72,55,17,35,88,74,93,10,59,3,64,95,91,61,28,63,23,49,6,24,47,41,88,96,23,90,53,84,3,35,23,3,17]