package com.madhu.psds.arrays;

import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-2];
        Deque<Integer> deque = new ArrayDeque<>();
        int length = nums.length;
        int i;
        int j =0;
        for(i=0;i<k;i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        for(;i<length;i++) {
            result[j++] = nums[deque.peekFirst()];
            while (!deque.isEmpty() &&  deque.peekFirst() <= (i - k) ) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        result[j++] = nums[deque.peekFirst()];
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {8,2,3,1,7,6};
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] maxs =  slidingWindowMaximum.maxSlidingWindow(nums,3);
        for(int i =0;i< maxs.length;i++) {
            System.out.print(" " + maxs[i]);
        }
    }
}
