package com.madhu.psds.trees;
//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
//116. Populating Next Right Pointers in Each Node

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNode populatingNextRightPointersInEachNode = new PopulatingNextRightPointersInEachNode();
        StringToNode stringToNode = new StringToNode();
        TreeNode root =  stringToNode.stringToTreeNode("[1,2,3,4,5,6,7]");
//        populatingNextRightPointersInEachNode.connect(root);
    }

    public Node connect(Node root) {
        if(root == null) return null;
        return root;
    }

    private void connectRecursiveInner(Node root) {
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
            connectRecursiveInner(root.left);
            connectRecursiveInner(root.right);
        }
    }

    public Node connectWithouRecursvie(Node root) {
        if(root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prevNode = null;
            while (size -- > 0) {
                Node currentNode = queue.poll();
                if(currentNode.left !=null) {
                    queue.offer(currentNode.left);
                    queue.offer(currentNode.right);
                }
                if(prevNode!=null) {
                    prevNode.next = currentNode;
                }
                prevNode = currentNode;
            }
            prevNode.right = null;
        }
        return root;
    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

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
