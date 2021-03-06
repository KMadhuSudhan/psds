package com.madhu.psds.matrix;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        };
        PriorityQueue pq = new PriorityQueue();

        pq.offer(1);
        pq.offer(-1);
        pq.offer(0);
        System.out.println(pq.peek());
        KthSmallestElementInSortedMatrix kthSmallestElementInSortedMatrix = new KthSmallestElementInSortedMatrix();
        kthSmallestElementInSortedMatrix.kthSmallest(matrix,8);


    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.val ,o2.val);
            }
        });

        int rows = matrix.length;
        int columns = matrix[0].length;
        Node node = new Node();
        node.val = matrix[0][0];
        node.i  = 0;
        node.j  = 0;
        priorityQueue.add(node);
        boolean[][] visited = new boolean[rows][columns];
        visited[0][0] = true;
        int[][] directions = {
                {0,1},
                {1,0}
        };
        while (!priorityQueue.isEmpty()) {
            Node cur = priorityQueue.poll();
            int i = cur.i;
            int j = cur.j;
            k--;
            if(k ==0) return cur.val;
            for(int[] direction: directions) {
                int nextI = i + direction[0];
                int nextJ = j + direction[1];
                if(nextI >= rows || nextJ >= columns || visited[nextI][nextJ]) continue;
                Node next = new Node();
                next.val = matrix[nextI][nextJ];
                next.i = nextI;
                next.j = nextJ;
                priorityQueue.add(next);
                visited[nextI][nextJ] = true;
            }
        }
        return -1;
    }

    class Node{
        Integer val;
        int i;
        int j;
    }
}
