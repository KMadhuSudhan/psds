package com.madhu.psds.arrays;
//https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
//373. Find K Pairs with Smallest Sums


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmalletSum {
    public static void main(String[] args) {
        FindKPairsWithSmalletSum smalletSum = new FindKPairsWithSmalletSum();
        int[] num1 = {1,1,2};
        int[] num2 = {1,2,3};
        List<List<Integer>> result =  smalletSum.kSmallestPairs(num1,num2,10);
        System.out.println(result);
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int num1Ln = nums1.length;
        int num2Ln = nums2.length;
        if(num1Ln == 0 || num2Ln == 0) return result;
        boolean[][] visited = new boolean[num1Ln][num2Ln];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return ((o1[0] + o1[2]) - (o2[0] + o2[1]));
            }
        });
        int[] temp = new int[]{nums1[0],nums2[0],0,0};
        priorityQueue.add(temp);
        int[][] dirs = {
                {1,0},
                {0,1},
                {1,1}
        };
        while (!priorityQueue.isEmpty()) {
            int[] arr = priorityQueue.poll();
            List<Integer> ls = new ArrayList<>();
            ls.add(arr[0]);ls.add(arr[1]);
            result.add(ls);
            k++;
            if(result.size() == k) break;
            int x = arr[2],y = arr[3];
            visited[x][y] = true;
            for (int[] dir : dirs) {
                int dx = x + dir[0];
                int dy = y + dir[1];
                if(dx>=num1Ln || dy >= num2Ln ||  visited[dx][dy]) continue;
                priorityQueue.add(new int[] {nums1[dx],nums2[dy],dx,dy});
                visited[dx][dy] = true;
            }
        }
        return result;
    }
}
