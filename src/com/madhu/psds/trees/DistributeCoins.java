package com.madhu.psds.trees;
//https://leetcode.com/problems/distribute-coins-in-binary-tree/
//979. Distribute Coins in Binary Tree

public class DistributeCoins {
    static int ans;
    public static void main(String[] args) {
        String nodes = "[0,0,null,0,0,null,null,0,0]";
        StringToNode stringToNode = new StringToNode();
        ans = 0;
        TreeNode root =  stringToNode.stringToTreeNode(nodes);
        DistributeCoins distributeCoins = new DistributeCoins();
        System.out.println(distributeCoins.distributeCoins(root));
    }
    public int distributeCoins(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = distributeCoins(root.left);
        int right = distributeCoins(root.right);
        ans += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }
}
