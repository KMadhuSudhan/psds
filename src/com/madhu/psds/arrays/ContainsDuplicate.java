package com.madhu.psds.arrays;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,1};
        int k =3;
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        containsDuplicate.containsNearbyDuplicate(numbers,k);
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int length = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<length;i++) {
            int count = map.getOrDefault(nums[i],0);
            map.put(nums[i],count);
        }
        return true;
    }
}
