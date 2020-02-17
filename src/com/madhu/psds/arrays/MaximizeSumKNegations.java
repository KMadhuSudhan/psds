package com.madhu.psds.arrays;

import java.util.PriorityQueue;

public class MaximizeSumKNegations {
    public int largestSumAfterKNegations(int[] A, int K) {
        int sum = 0;
        int index = -1;
        for(int i =0;i<K;i++) {
            int min = Integer.MAX_VALUE;
            for (int j=0;j<A.length;j++) {
                if(A[j] < min) {
                    min = A[j];
                    index = j;
                }
            }
            if(min == 0) break;
            A[index] = -A[index];
        }
        for (int i =0;i<A.length;i++) {
            sum+=A[i];
        }
        return sum;
    }

    public int largestSumAfterKNegationsUsingQueue(int[] A, int K) {
        // Create a priority queue and insert all array elements
        // int
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : A)
            pq.add(x);

        // Do k negations by removing a minimum element k times
        while (K-- > 0)
        {
            // Retrieve and remove min element
            int temp = pq.poll();

            // Modify the minimum element and add back
            // to priority queue
            temp *= -1;
            pq.add(temp);
        }

        // Compute sum of all elements in priority queue.
        int sum = 0;
        for (int x : pq)
            sum += x;
        return sum;
    }

    public static void main(String[] args) {
        int[] A = {4,2,3};
        int K = 1;
        MaximizeSumKNegations maximizeSumKNegations = new MaximizeSumKNegations();
        maximizeSumKNegations.largestSumAfterKNegations(A,K);
    }
}
