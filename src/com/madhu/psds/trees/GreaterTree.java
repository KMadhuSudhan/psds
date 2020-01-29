package com.madhu.psds.trees;

import java.util.Stack;

public class GreaterTree {
    private int treesum = 0;
    public static void main(String args) {
        GreaterTree greaterTree = new GreaterTree();
        BST bst = new BST();
        int[] nodes = new int[]{5,2,13};
        bst.bulkInsert(nodes);
        greaterTree.convertBST(bst.root);
    }

    //recursive
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            treesum += root.val;
            root.val = treesum;
            convertBST(root.left);
        }
        return root;
    }

    //iterative
    public TreeNode convertBSTIterative(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (!stack.isEmpty() || node != null) {
            /* push all nodes up to (and including) this subtree's maximum on
             * the stack. */
            while (node != null) {
                stack.add(node);
                node = node.right;
            }

            node = stack.pop();
            sum += node.val;
            node.val = sum;

            /* all nodes with values between the current and its parent lie in
             * the left subtree. */
            node = node.left;
        }

        return root;
    }
}
