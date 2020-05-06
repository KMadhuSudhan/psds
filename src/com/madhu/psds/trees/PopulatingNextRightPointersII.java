package com.madhu.psds.trees;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
public class PopulatingNextRightPointersII {
    public static void main(String[] args) {
        PopulatingNextRightPointersII populatingNextRightPointersII = new PopulatingNextRightPointersII();
    }

    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prevNode = null;
            while (size-- > 0) {
                Node currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
                if (prevNode != null) {
                    prevNode.next = currentNode;
                }
                prevNode = currentNode;
            }
        }
        return root;
    }

    private void connectRecursiveInner(Node root) {
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null && root.right != null) {
                if (root.next.left != null) {
                    root.right.next = root.next.left;
                } else if (root.next.right != null) {
                    root.right.next = root.next.right;
                }
            }
            connectRecursiveInner(root.left);
            connectRecursiveInner(root.right);
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
