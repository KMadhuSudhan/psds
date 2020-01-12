package com.madhu.psds.trees;

public class TrimBinaryTree {
    public static void main(String[] args) {
        int[] node = new int[]{1, 0, 2};
        BST bst = new BST();
        TrimBinaryTree trimBinaryTree = new TrimBinaryTree();
        bst.bulkInsert(node);
        trimBinaryTree.trimBST(bst.root, 1, 2);
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;

        int val = root.val;
        if (val < L) return trimBST(root.right, L, R);
        if (val > R) return trimBST(root.left, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
