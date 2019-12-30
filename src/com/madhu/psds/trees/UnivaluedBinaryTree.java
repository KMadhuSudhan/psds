package com.madhu.psds.trees;

public class UnivaluedBinaryTree {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        int rootVal = root.val;
        return isUnivalueTree(root,root.val);
    }

    public boolean isUnivalueTree(TreeNode root,int val) {
        if(root == null) return true;
        return root.val == val && isUnivalueTree(root.left,val) && isUnivalueTree(root.right,val);
    }
}
