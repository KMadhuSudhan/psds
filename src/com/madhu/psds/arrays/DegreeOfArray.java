package com.madhu.psds.arrays;
//https://leetcode.com/problems/degree-of-an-array/submissions/
//697. Degree of an Array

import java.util.HashMap;
import java.util.Map;

public class DegreeOfArray {
    class Track {
        int count;
        int lowIndex;
        int highIndex;
    }

    public static void main(String[] args) {
        DegreeOfArray degreeOfArray = new DegreeOfArray();
        int[] arr = {1, 2, 2, 3, 1};
        degreeOfArray.findShortestSubArray(arr);
    }

    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Track> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                Track track = hashMap.get(nums[i]);
                track.count++;
                track.highIndex = i;
            } else {
                Track track = new Track();
                track.count = 1;
                track.lowIndex = i;
                track.highIndex = i;
                hashMap.put(nums[i], track);
            }
        }
        int frequency = Integer.MAX_VALUE, count = 0;
        for (Map.Entry<Integer, Track> entry : hashMap.entrySet()) {
            int numCount = entry.getValue().count;
            int numFrequency = entry.getValue().highIndex - entry.getValue().lowIndex + 1;
            if (numCount >= count) {

                if (numFrequency < frequency || numCount > count) {
                    count = numCount;
                    frequency = numFrequency;
                }
            }
        }
        return frequency == Integer.MIN_VALUE ? 0 : frequency;
    }
}
