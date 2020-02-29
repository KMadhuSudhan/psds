package com.madhu.psds.trees;
//https://leetcode.com/problems/binary-tree-level-order-traversal/
//102. Binary Tree Level Order Traversal

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrder {
    public static void main(String[] args) {
        BinaryTreeLevelOrder binaryTreeLevelOrder = new BinaryTreeLevelOrder();
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size -- >0) {
                TreeNode polled = queue.poll();
                level.add(polled.val);
                if(polled.left!=null) queue.add(polled.left);
                if(polled.right!=null) queue.add(polled.right);
            }
            result.add(level);
        }
        return result;
    }
}
