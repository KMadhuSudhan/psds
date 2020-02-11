package com.madhu.psds.trees;
//https://leetcode.com/problems/symmetric-tree/
//101. Symmetric Tree

public class SymmetricTree {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] nodes = {1, 2, 2, 3, 4, 4, 3};
        bst.bulkInsert(nodes);
        SymmetricTree symmetricTree = new SymmetricTree();
        symmetricTree.isSymmetric(bst.root);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 != null && node2 != null && node1.val == node2.val && isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left))
            return true;
        return false;
    }
}
