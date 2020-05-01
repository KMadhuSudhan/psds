package com.madhu.psds.trees;

import java.util.LinkedList;
import java.util.Queue;
//https://leetcode.com/problems/complete-binary-tree-inserter/
//919. Complete Binary Tree Inserter

public class CBTInserter {
    TreeNode root;
    private Queue<TreeNode> leafQueue;
    public CBTInserter(TreeNode root) {
        this.root = root;
        leafQueue = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // populate leaf queue
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null || node.right == null) leafQueue.offer(node);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }

    public int insert(int v) {
        TreeNode node = leafQueue.peek();
        TreeNode newNode = new TreeNode(v);
        leafQueue.offer(newNode);
        if (node.left == null) node.left = newNode;
        else {
            node.right = newNode;
            leafQueue.poll();
        }
        return node.val;
    }

    public TreeNode get_root() {
        return this.root;
    }
}
