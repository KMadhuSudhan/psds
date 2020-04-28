package com.madhu.psds.trees;
//https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/submissions/
//1339. Maximum Product of Splitted Binary Tree

public class MaxProductOfSlittedBinaryTree {
    long ans = 0;
    public int maxProduct(TreeNode root) {
        int sum = sum(root);
        product(root,sum);
        ans = ans % 1000000007;
        return (int) ans;
    }

    private int sum(TreeNode root) {
        if(root ==null) return 0;
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return root.val + leftSum +  rightSum;
    }

    private int product(TreeNode root,int sum) {
        if(root ==null) return 0;
        int left = product(root.left,sum);
        int right = product(root.right,sum);
        int s = left + right + root.val;
        ans = (long) Math.max(ans,(long)(sum-s)*s);
        return root.val + left +  right;
    }
}
