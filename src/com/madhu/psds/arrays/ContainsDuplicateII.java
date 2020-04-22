package com.madhu.psds.arrays;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[] nums = {-1,2147483647};

        ContainsDuplicateII containsDuplicateII = new ContainsDuplicateII();
        System.out.println(containsDuplicateII.containsNearbyAlmostDuplicate(nums,1,2147483647));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int length = nums.length;
        if(length<=1) return false;
        for(int i=0;i<length-1;i++) {
            for(int j=i+1;j-i<=k && j<length;j++) {
                if (Math.abs((long) nums[i]- (long) nums[j]) <= t) return true;
            }
        }
        return false;
    }
}
