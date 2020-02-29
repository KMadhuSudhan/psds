package com.madhu.psds.trees;
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
//103. Binary Tree Zigzag Level Order Traversal

import java.util.*;

public class BinaryTreeZigZag {
    public static void main(String[] args) {
        BinaryTreeZigZag binaryTreeZigZag = new BinaryTreeZigZag();
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> levelResult = new ArrayList<>();
            while (!stack1.isEmpty()) {
                TreeNode popNode = stack1.pop();
                levelResult.add(popNode.val);
                if (popNode.right != null) stack2.push(popNode.right);
                if (popNode.left != null) stack2.push(popNode.left);
            }
            if(!levelResult.isEmpty()) result.add(levelResult);
            levelResult = new ArrayList<>();
            while (!stack2.isEmpty()) {
                TreeNode popNode = stack2.pop();
                levelResult.add(popNode.val);
                if (popNode.left != null) stack1.push(popNode.left);
                if (popNode.right != null) stack1.push(popNode.right);
            }
            if(!levelResult.isEmpty()) result.add(levelResult);
        }
        return result;
    }
}
