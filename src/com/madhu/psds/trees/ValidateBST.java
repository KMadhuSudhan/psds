package com.madhu.psds.trees;
//https://leetcode.com/problems/validate-binary-search-tree/
//98. Validate Binary Search Tree

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        return isBSTUtil(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean isBSTUtil(TreeNode node, long min, long max)
    {
        /* an empty tree is BST */
        if (node == null)
            return true;

        /* false if this node violates the min/max constraints */
        if (node.val <= min || node.val >= max)
            return false;

        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (isBSTUtil(node.left, min, node.val) &&
                isBSTUtil(node.right, node.val, max));
    }
}
