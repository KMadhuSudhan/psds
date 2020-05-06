package com.madhu.psds.arrays;
//https://leetcode.com/problems/majority-element/
//169. Majority Element
//https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        MajorityElement majorityElement = new MajorityElement();
        majorityElement.majorityElement(nums);
    }
    public int majorityElement(int[] nums) {
        int majElement = 0, count=1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[majElement]){
                count++;
            }else{
                count--;
            }
            if(count==0){
                majElement=i;
                count=1;
            }
        }
        return nums[majElement];
    }
}
