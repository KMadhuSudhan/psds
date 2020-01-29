package com.madhu.psds.trees;

public class TwoSumTree {
    public static void main(String[] args) {
        int[] nodes = {5,3,6,2,4,7};
        BST bst = new BST();
        bst.bulkInsert(nodes);
        TwoSumTree twoSumTree = new TwoSumTree();
        twoSumTree.findTarget(bst.root,9);
    }

    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        if(Math.abs(k - root.val) == 1) return true;
        return true;
    }
}
