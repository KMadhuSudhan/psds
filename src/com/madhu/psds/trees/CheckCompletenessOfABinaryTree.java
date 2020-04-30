package com.madhu.psds.trees;
//https://leetcode.com/problems/check-completeness-of-a-binary-tree
//958. Check Completeness of a Binary Tree

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfABinaryTree {
    public static void main(String[] args) {
        CheckCompletenessOfABinaryTree checkCompletenessOfABinaryTree = new CheckCompletenessOfABinaryTree();
        StringToNode stringToNode = new StringToNode();
        TreeNode root =  stringToNode.stringToTreeNode("[1,2,3,4,5,6]");
        checkCompletenessOfABinaryTree.isCompleteTree(root);
    }

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = false;

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.left!=null) {
                if(flag == true) return false;
                queue.add(node.left);
            } else {
                flag = true;
            }

            if(node.right!=null) {
                if(flag == true) return false;
                queue.add(node.right);
            } else {
                flag = true;
            }
        }
        return true;
    }
}
