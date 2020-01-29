package com.madhu.psds.trees;

public class BinarySearchLca {
    public static void main(String[] args) {
        int[] nodes = {6, 2, 8, 0, 4, 7, 9, 3, 5};
        BST bst = new BST();
        bst.bulkInsert(nodes);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(8);
        BinarySearchLca binarySearchLca = new BinarySearchLca();
        binarySearchLca.lowestCommonAncestor(bst.root, t1, t2);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;

        if ((p.val < root.val && root.val < q.val) || (p.val > root.val && root.val > q.val)) {
            return root;
        } else if ((root.val < p.val && p.val < q.val) || (root.val < q.val && q.val < p.val)) {
            return lowestCommonAncestor(root.right, p, q);
        } else
            return lowestCommonAncestor(root.left, p, q);
    }
}
