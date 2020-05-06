package com.madhu.psds.trees;
//https://leetcode.com/problems/recover-binary-search-tree/submissions/
//99. Recover Binary Search Tree

public class RecoverBinarySearch  {
    TreeNode first = null,second = null;
    TreeNode previous = null;
    public static void main(String[] args) {

    }
    public void recoverTree(TreeNode root) {
        if(root == null) return ;
        inorder(root);
        if(first!=null && second!=null) {
            int temp = second.val;
            second.val = first.val;
            first.val = temp;
        }
    }
    public void inorder(TreeNode root) {
        if(root == null) return ;
        inorder(root.left);
        if(previous!=null && previous.val > root.val) {
            if(first == null) first = previous;
            second = root;
        }
        previous = root;
        inorder(root.right);
    }
}
