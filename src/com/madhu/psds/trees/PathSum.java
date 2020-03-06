package com.madhu.psds.trees;
//https://leetcode.com/problems/path-sum-iii
//437. Path Sum III

public class PathSum {
    int count = 0;
    public static void main(String[] args) {

    }
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return count;
        dfs(root,sum);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return count;
    }

    public void dfs(TreeNode root, int sum) {
        if(root == null) return;
        sum = sum - root.val;
        if(sum == 0){
            count++;
        }
        if(root.left == null && root.right ==null) return;
        dfs(root.left,sum);
        dfs(root.right,sum);
    }
}
