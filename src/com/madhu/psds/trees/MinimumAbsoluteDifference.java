package com.madhu.psds.trees;

import java.util.Stack;

public class MinimumAbsoluteDifference {
    int minDiff;
    public static void main(String[] args) {
        int[] nodes = {1,3,2};
        BST bst = new BST();
        bst.bulkInsert(nodes);
        MinimumAbsoluteDifference minimumAbsoluteDifference = new MinimumAbsoluteDifference();
        Stack<TreeNode> stack = new Stack<>();
        minimumAbsoluteDifference.getMinimumDifference(bst.root,stack);
    }


    public void getMinimumDifference(TreeNode root,Stack<TreeNode> stack) {
        if(root!=null) {
            if(!stack.empty()) {
                minDiff = Math.min(minDiff,Math.abs(root.val -  stack.peek().val));
            }
            stack.push(root);
            getMinimumDifference(root.left,stack);
            getMinimumDifference(root.right,stack);
        }
    }

}
