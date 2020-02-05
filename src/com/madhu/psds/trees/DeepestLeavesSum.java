package com.madhu.psds.trees;
//https://leetcode.com/problems/deepest-leaves-sum/
//1302. Deepest Leaves Sum

import java.util.HashMap;
import java.util.Map;

public class DeepestLeavesSum {
    private int maxDepth = 0;
    private Map<Integer,Integer> sumMap = new HashMap<>();

    public static void main(String[] args) {
        int[] nodes = {1,2,3,4,5,6,7,8};
        BST bst = new BST();
        bst.bulkInsert(nodes);
        DeepestLeavesSum deepestLeavesSum = new DeepestLeavesSum();
        deepestLeavesSum.deepestLeavesSum(bst.root);
    }

    public int deepestLeavesSum(TreeNode root) {
        deepestLeavesSum(root,0);
        return sumMap.get(maxDepth);
    }

    public void deepestLeavesSum(TreeNode root,int depth) {
        if(root == null) return;
        if(maxDepth < depth && root.left == null && root.right == null) {
            maxDepth = depth;
            int sum = sumMap.getOrDefault(depth,0);
            sumMap.put(depth,sum + root.val);
        } else if(maxDepth == depth) {
            int sum = sumMap.getOrDefault(depth,0);
            sumMap.put(depth,sum + root.val);
        }

        deepestLeavesSum(root.left,depth+1);
        deepestLeavesSum(root.right,depth+1);
    }
}
