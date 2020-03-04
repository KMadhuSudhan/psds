package com.madhu.psds.arrays;
//https://leetcode.com/problems/set-mismatch/submissions/
//645. Set Mismatch

import java.util.HashSet;
import java.util.Set;

public class SetMismatch {
    public static void main(String[] args) {
        int[] nums = {2,2};
        SetMismatch setMismatch = new SetMismatch();
        int[] a =  setMismatch.findErrorNums(nums);
        System.out.println(setMismatch.missingNumber(nums,nums.length));
//        System.out.println(" " + a[1]);
    }
    public int[] findErrorNums(int[] nums) {
        int length = nums.length;
        int duplicate = Integer.MAX_VALUE;
        int sum = 0;
        int totalSum = length*(length+1)/2;
        for (int i = 0; i < length; i++) {
            sum+=nums[i];
        }
        for (int i = 0; i < length; i++) {
            if (nums[Math.abs(nums[i]) -1] < 0) {
                duplicate =  Math.abs(nums[i]);
                break;
            }
            nums[Math.abs(nums[i]) -1] = -nums[Math.abs(nums[i]) -1];
        }
        sum = sum - duplicate;
        int missing = totalSum - sum;
        return new int[]{duplicate,missing};
    }

    public int missingNumber(int[] a,int n) {
        int x1 = a[0];
        int x2 = 1;

        /* For xor of all the elements
           in array */
        for (int i = 1; i < n; i++)
            x1 = x1 ^ a[i];

        /* For xor of all the elements
           from 1 to n+1 */
        for (int i = 2; i <= n + 1; i++)
            x2 = x2 ^ i;

        return (x1 ^ x2);
    }

    public int[] findErrorNumsTwo(int[] nums) {
        /*
        We use a set to keep track of the values in the array and if a number occurrs twice, we add it to the result and count
        from [1,nums.length] if a value isn't there, we add it to the result

        Time and space complexity = O(n)
        */
        if(nums == null) return nums;
        //using a set to get the number that occurs twice
        Set<Integer> contains_duplicate = new HashSet<>();
        int[] result = new int[2];
        for(int val : nums){
            if(contains_duplicate.contains(val)){
                result[0] = val;
            }else{
                contains_duplicate.add(val);
            }
        }
        //we then loop from {1, nums} to see if each value occurs in the set if it doens't we add it to the result
        for(int i = 1; i<= nums.length; i++){
            if(!contains_duplicate.contains(i)){ //if i is not in the set, we add it
                result[1] = i;
            }
        }
        return result;
    }

}
