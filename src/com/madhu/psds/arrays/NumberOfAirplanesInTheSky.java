package com.madhu.psds.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class NumberOfAirplanesInTheSky {

    public static void main(String[] args) {
        int[][] intervals = {{1, 10}, {2, 3}, {5, 8}, {4, 7}};
        NumberOfAirplanesInTheSky numberOfAirplanesInTheSky = new NumberOfAirplanesInTheSky();
        System.out.println(numberOfAirplanesInTheSky.countOfAirplanes(intervals));
    }

    public int countOfAirplanes(int[][] intervals) {
        int ans = 0, count = 0;
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<Pair>(1, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.time!=o2.time) {
                   return o1.time - o2.time;
                } else {
                    return o1.flag - o2.flag;
                }
            }
        });
        for (int i=0;i<intervals.length;i++) {
            Pair p1 =  new Pair(intervals[0][0],1);
            Pair p2 =  new Pair(intervals[0][1],0);
            priorityQueue.add(p1);
            priorityQueue.add(p2);
        }
        while (!priorityQueue.isEmpty()) {
            Pair p = priorityQueue.poll();
            if(p.flag == 1) {
                count++;
            } else {
                count--;
            }
            ans = Math.max(ans,count);
        }
        return ans;
    }

    class Pair {
        int time,flag;
        Pair(int time,int flag) {
            this.time = time;
            this.flag = flag;
        }
    }
}
