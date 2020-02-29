package com.madhu.psds.trees;
//https://leetcode.com/problems/minimum-depth-of-binary-tree/
//111. Minimum Depth of Binary Tree

public class MinimumDepthOfTree {
    public static void main(String[] args) {
        MinimumDepthOfTree minimumDepthOfTree = new MinimumDepthOfTree();
        String nodes = "[1,2]";
        StringToNode stringToNode = new StringToNode();
        TreeNode root =  stringToNode.stringToTreeNode(nodes);
        System.out.println(minimumDepthOfTree.minDepth(root));
    }
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        if(root.left == null)
            return minDepth(root.right) +1;
        if(root.right == null)
            return minDepth(root.left) +1;
        return Math.min(minDepth(root.left),minDepth(root.right))  +1;
    }
}
