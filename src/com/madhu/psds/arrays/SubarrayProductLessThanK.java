package com.madhu.psds.arrays;

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        SubarrayProductLessThanK subarrayProductLessThanK = new SubarrayProductLessThanK();
        int[] num = {10, 5, 2, 6};
        subarrayProductLessThanK.numSubarrayProductLessThanK(num,100);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }
}
