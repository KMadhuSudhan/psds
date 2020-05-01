package com.madhu.psds.arrays;
//https://leetcode.com/problems/circular-array-loop/
//457. Circular Array Loop

import java.util.HashSet;
import java.util.Set;

public class CircularArrayLoop {
    public static void main(String[] args) {
        int[] nums = {1,1};
        CircularArrayLoop circularArrayLoop = new CircularArrayLoop();
        System.out.println(circularArrayLoop.circularArrayLoop(nums));
    }

    public boolean circularArrayLoop(int[] nums) {
        //the idea is to loop through every single starting element and examine if the element form a loop
        for (int i = 0; i < nums.length; i++) {
            boolean hasCycle = examineLoop(nums, i);
            if (hasCycle) {
                return true;
            }
        }
        return false;
    }

    private boolean examineLoop(int[] nums, int start) {
        Set<Integer> visitedIndex = new HashSet<>();
        //track all visited index - if we reach a visited index we end the traversal
        boolean isForwardCycle = nums[start] > 0;

        int i = start;
        int length = 0;
        while (!visitedIndex.contains(i)) {
            visitedIndex.add(i);
            if (nums[i] > 0 == isForwardCycle) {
                //moving in the same direction
                i = wrapIndex(nums.length, i + nums[i]);
                length++;
            } else {
                //moving in the other direction, no loop
                return false;
            }
        }
        //if we end at the starting index and the length is greater than 1
        return i == start && length > 1;
    }

    //helper method to do proper modulo (java % calcualtes remainder not modulo).
    private int wrapIndex(int length, int i) {
        return Math.floorMod(i, length);
    }
}
