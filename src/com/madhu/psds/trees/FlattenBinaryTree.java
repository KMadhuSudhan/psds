package com.madhu.psds.trees;
//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
//114. Flatten Binary Tree to Linked List

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FlattenBinaryTree {
    public static void main(String[] args) {
        FlattenBinaryTree flattenBinaryTree = new FlattenBinaryTree();
        StringToNode stringToNode = new StringToNode();
        TreeNode root = stringToNode.stringToTreeNode("[1,2,5,3,4,6]");
        flattenBinaryTree.flatten(root);
    }

    public void flattenIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            if (root.right != null) stack.push(root.right);
            if (root.left != null) {
                root.right = root.left;
                root.left = null;
                root = root.right;
            } else if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                root.right = pop;
            }
            root.left = null;
            root = root.right;
        }
    }

    public void flatten(TreeNode root) {
       if(root == null) return;
       if(root.left == null && root.right == null) return;
       if(root.left!=null) {
           flatten(root.left);
           TreeNode temp = root.right;
           root.right = root.left;
           root.left = null;
           TreeNode rightRoot =  root.right;
           while (rightRoot.right!=null) {
               rightRoot = rightRoot.right;
           }
           rightRoot.right = temp;
       }
        flatten(root.right);
    }
}
