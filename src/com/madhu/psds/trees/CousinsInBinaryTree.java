package com.madhu.psds.trees;
//https://leetcode.com/problems/cousins-in-binary-tree/
//993. Cousins in Binary Tree

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {
    public static void main(String[] args) {
        CousinsInBinaryTree cousinsInBinaryTree = new CousinsInBinaryTree();
        StringToNode stringToNode = new StringToNode();
        TreeNode root = stringToNode.stringToTreeNode("[1,2,3,4]");
        System.out.println(cousinsInBinaryTree.isCousins(root, 4, 3));
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Cousins cousins = new Cousins(root.val, root.left, root.right, Integer.MAX_VALUE);
        Queue<Cousins> queue = new LinkedList<>();
        queue.add(cousins);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean xFound = false;
            boolean yFound = false;
            int xParent = Integer.MAX_VALUE;
            int yParent = Integer.MIN_VALUE;
            while (size-- > 0) {
                Cousins poll = queue.poll();
                if (poll.val == x) {
                    xFound = true;
                    xParent = poll.parent;
                }
                if (poll.val == y) {
                    yFound = true;
                    yParent = poll.parent;
                }
                if (poll.left != null) {
                    TreeNode left = poll.left;
                    Cousins leftCousin = new Cousins(left.val, left.left, left.right, poll.val);
                    queue.add(leftCousin);
                }
                if (poll.right != null) {
                    TreeNode right = poll.right;
                    Cousins rightCousin = new Cousins(right.val, right.left, right.right, poll.val);
                    queue.add(rightCousin);
                }
            }
            if (xFound && yFound && xParent != yParent) return true;
            if (xFound || yFound) return false;
        }
        return false;
    }

    class Cousins {
        TreeNode left;
        TreeNode right;
        int parent;
        int val;

        Cousins(int val, TreeNode left, TreeNode right, int parent) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
}
