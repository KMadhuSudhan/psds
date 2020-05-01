package com.madhu.psds.trees;
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
//236. Lowest Common Ancestor of a Binary Tree
public class LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        if(root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode leftLca =  lowestCommonAncestor(root.left,p,q);
        TreeNode rightLca =  lowestCommonAncestor(root.right,p,q);

        if(leftLca!=null&&rightLca!=null) {
            return root;
        }
        return leftLca!=null? leftLca : rightLca;
    }
}
