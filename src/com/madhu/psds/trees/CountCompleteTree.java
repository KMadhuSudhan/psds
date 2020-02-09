package com.madhu.psds.trees;
//https://leetcode.com/problems/count-complete-tree-nodes/
//222. Count Complete Tree Nodes

public class CountCompleteTree {
    int count = 0;
    public int countNodes(TreeNode root) {
        inOrder(root);
        return count;
    }

    public void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        count++;
        inOrder(root.right);
    }
}
