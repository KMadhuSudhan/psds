package com.madhu.psds.trees;
//https://leetcode.com/problems/path-sum-iii
//437. Path Sum III

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    int count = 0;
    List<TreeNode> list = new ArrayList<>();
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

    //iterative

    public int pathSumr(TreeNode root, int sum) {
        if(root == null) return count;
        list.add(root);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        int pathSum = 0;
        for(int j= list.size()-1;j>=0;j--) {
            pathSum+=list.get(j).val ;
            if(pathSum == sum) {
                count++;
            }
        }
        return count;
    }
}
