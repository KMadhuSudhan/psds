package com.madhu.psds.trees;
//https://leetcode.com/problems/same-tree/
//100. Same Tree

public class SameTree {
    public static void main(String[] args) {
        BST bst1 = new BST();
        BST bst2 = new BST();
        int[] nodes1 = {1, 2, 3};
        int[] nodes2 = {1, 2, 3};
        SameTree sameTree = new SameTree();
        sameTree.isSameTree(bst1.root, bst2.root);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
            return true;
        return false;
    }
}

