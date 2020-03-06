package com.madhu.psds.trees;
//1038. Binary Search Tree to Greater Sum Tree
//https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
public class BstToGst {
    int sum = 0;
    public static void main(String[] args) {
        BstToGst bstToGst = new BstToGst();
    }
    public TreeNode bstToGst(TreeNode root) {
        if(root == null) return null;
        bstToGst(root.right);
        sum +=root.val;
        root.val = sum;
        bstToGst(root.left);
        return root;
    }
}
