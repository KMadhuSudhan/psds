package com.madhu.psds.trees;
//https://leetcode.com/problems/path-sum-iii/
//437. Path Sum III

public class PathSumIII {
    private int noOfSums = 0;
    public static void main(String[] args) {

    }

    public int pathSum(TreeNode root, int sum) {
        int currentSum = 0;
        pathSum(root,sum,currentSum);
        return noOfSums;
    }

    public void pathSum(TreeNode root, int sum,int currentSum) {
        if(root == null) return;
        currentSum+=root.val;
        if(currentSum == sum) {
            noOfSums++;
        }
        pathSum(root.left,sum,currentSum);
        pathSum(root.right,sum,currentSum);
    }
}
