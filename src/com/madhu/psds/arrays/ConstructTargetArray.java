package com.madhu.psds.arrays;
//https://leetcode.com/problems/construct-target-array-with-multiple-sums/
//1354. Construct Target Array With Multiple Sums


import java.util.PriorityQueue;

public class ConstructTargetArray {
    public static void main(String[] args) {
        int[] arr = {9, 3, 5};
        ConstructTargetArray constructTargetArray = new ConstructTargetArray();
        System.out.println(constructTargetArray.isPossible(arr));
    }

    public boolean isPossible(int[] target) {
        int cur_sum = 0;
        PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>((a, b)->(b-a));

        for(int ele: target){
            //cur_max = Math.max(cur_max, ele);
            cur_sum += ele;
            maxheap.offer(ele);
        }


        while(maxheap.size()!=0){
            int largest = maxheap.poll();
            if(largest == 1){
                return true;
            }

            int other_sum = cur_sum - largest;
            if(other_sum<=0 || largest<=other_sum){
                return false;
            }
            if(other_sum==1){
                return true;
            }
            int original_num = largest%other_sum;

            maxheap.offer(original_num);
            cur_sum = other_sum + original_num;
        }

        return false;
    }
}
