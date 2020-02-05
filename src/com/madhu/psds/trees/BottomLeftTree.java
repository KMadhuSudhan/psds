package com.madhu.psds.trees;


public class BottomLeftTree {
    private int maxDepth = 0;
    private int val = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, 4, 5, 6, 7};
        BottomLeftTree bottomLeftTree = new BottomLeftTree();
        BST bst = new BST();
        bst.bulkInsert(nodes);
        bottomLeftTree.findBottomLeftValue(bst.root);
    }

    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root, false, 0);
        return val;
    }

    public void findBottomLeftValue(TreeNode root, Boolean isLeft, int depth) {
        if (root.left == null && root.right == null && isLeft && maxDepth < depth) {
            maxDepth = depth;
            val = root.val;
        }
        findBottomLeftValue(root.left, true, depth + 1);
        findBottomLeftValue(root.right, false, depth + 1);
    }
}
