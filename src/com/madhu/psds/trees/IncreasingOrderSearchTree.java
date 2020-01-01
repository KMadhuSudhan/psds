package com.madhu.psds.trees;

import java.util.Stack;

public class IncreasingOrderSearchTree {
    public static void main(String[] args) {
        int[] nodes = new int[]{5,3,6,2,4,8,1,7,9};
        BST bst = new BST();
        IncreasingOrderSearchTree increasingOrderSearchTree = new IncreasingOrderSearchTree();
        bst.bulkInsert(nodes);
        increasingOrderSearchTree.increasingBST(bst.root);
    }

    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode p = root;
        TreeNode newRoot = null;
        TreeNode parent = null;
        while (true) {
            if(p!=null) {
                stack.push(p);
                p = p.left;
            } else {
                if(stack.isEmpty()) break;
                TreeNode popedNode = stack.pop();
                if(newRoot == null) {
                    newRoot = new TreeNode(popedNode.val);
                    parent = newRoot;
                } else {
                    parent.right = new TreeNode(popedNode.val);
                    parent = parent.right;
                }
                p = popedNode.right;
            }
        }
        return newRoot;
    }
}
