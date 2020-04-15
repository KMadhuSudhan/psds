package com.madhu.psds.matrix;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestNumberMultiplicationTable {
    public static void main(String[] args) {
        KthSmallestNumberMultiplicationTable kthSmallestNumberMultiplicationTable = new KthSmallestNumberMultiplicationTable();
        kthSmallestNumberMultiplicationTable.findKthNumber(3,3,5);
    }
    public int findKthNumber(int m, int n, int k) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1,Node o2) {
                return Integer.compare(o1.val ,o2.val);
            }
        });

        int[][] matrix = new int[m][n];
        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++) {
                matrix[i-1][j-1] = i * j;
            }
        }
        Node node = new Node();
        node.val = matrix[0][0];
        node.i  = 0;
        node.j  = 0;
        priorityQueue.add(node);
        boolean[][] visited = new boolean[m][n];
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
                if(nextI >= m || nextJ >= n || visited[nextI][nextJ]) continue;
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
