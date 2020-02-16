package com.madhu.psds.arrays;

public class RangeSumQueryImmutable {
    private int[] sum;
    public  void NumArray(int[] nums) {
        sum = new int[nums.length+1];
        for (int i = 1; i < nums.length; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQueryImmutable rangeSumQueryImmutable = new RangeSumQueryImmutable();
        rangeSumQueryImmutable.NumArray(nums);
        System.out.println(rangeSumQueryImmutable.sumRange(0,2));
    }
}
