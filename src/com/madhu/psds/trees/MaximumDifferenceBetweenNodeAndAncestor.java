package com.madhu.psds.trees;
//https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/submissions/
//1026. Maximum Difference Between Node and Ancestor

public class MaximumDifferenceBetweenNodeAndAncestor {
    public static void main(String[] args) {
        StringToNode stringToNode = new StringToNode();
        TreeNode treeNode =  stringToNode.stringToTreeNode("[8,3,10,1,6,null,14,null,null,4,7,13]");
        MaximumDifferenceBetweenNodeAndAncestor tree = new MaximumDifferenceBetweenNodeAndAncestor();
        System.out.println(tree.maxAncestorDiff(treeNode));
    }
    public int maxAncestorDiff(TreeNode root) {
        return maxDiff(root,root.val,root.val,Integer.MIN_VALUE);
    }
    public int maxDiff(TreeNode root,int min,int max,int result) {
        if(root == null) return result;
        int val = Math.max(Math.abs(min-root.val),Math.abs(max-root.val));
        result = Math.max(val,result);
        min = Math.min(min,root.val);
        max = Math.max(max,root.val);
        return Math.max(maxDiff(root.left,min,max,result),maxDiff(root.right,min,max,result));
    }
}
