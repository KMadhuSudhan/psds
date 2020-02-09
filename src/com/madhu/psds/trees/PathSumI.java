package com.madhu.psds.trees;
//https://leetcode.com/problems/path-sum/submissions/
//112. Path Sum

public class PathSumI {
    private boolean foundPath = false;
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        int runningSum = 0;
        pathSum(root, sum, runningSum);
        return foundPath;
    }
    public void pathSum(TreeNode root, int sum, int runningSum) {
        if (root == null || foundPath) return;
        runningSum += root.val;
        if (runningSum == sum && root.left == null && root.right == null) {
            foundPath = true;
        } else {
            pathSum(root.left, sum, runningSum);
            pathSum(root.right, sum, runningSum);
        }
    }
}
