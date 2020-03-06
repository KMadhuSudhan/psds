package com.madhu.psds.trees;

public class LowestCommonAncestorDeepestLeaves {
    int maxDepth = 0;
    public static void main(String[] args) {
        LowestCommonAncestorDeepestLeaves lowestCommonAncestorDeepestLeaves = new LowestCommonAncestorDeepestLeaves();

    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
       return lcaDeepestLeaves(root,0);
    }

    public TreeNode lcaDeepestLeaves(TreeNode root,int depth) {
        if(root == null) {
            return null;
        }
        if(root.left == null && root.right == null && maxDepth < depth) {
            maxDepth = Math.max(maxDepth,depth);
            return root;
        }
        TreeNode leftLca =  lcaDeepestLeaves(root.left,depth+1);
        TreeNode rightLca =  lcaDeepestLeaves(root.right,depth+1);
        if(leftLca!=null&&rightLca!=null) {
            return root;
        }
        return leftLca!=null? lcaDeepestLeaves(root.left,depth+1) : lcaDeepestLeaves(root.right,depth+1);
    }
}
