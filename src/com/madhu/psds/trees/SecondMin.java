package com.madhu.psds.trees;
//https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
//671. Second Minimum Node In a Binary Tree

public class SecondMin {
    int firstMin = Integer.MAX_VALUE;
    int secondMin = Integer.MAX_VALUE;
    boolean seenMoreThanOnce = false;
    int original = -1;

    public static void main(String[] args) {
        BST bst = new BST();
        int[] nodes = {2, 2, 5, 5, 7};
        SecondMin secondMin = new SecondMin();
        bst.bulkInsert(nodes);
        secondMin.findSecondMin(bst.root);
    }

    public int findSecondMin(TreeNode root) {
        if (root == null) return -1;
        original = root.val;
        inorder(root);
        if (firstMin == secondMin || !seenMoreThanOnce) {
            return -1;
        }
        return secondMin;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        if (root.val != original) {
            seenMoreThanOnce = true;
        }
        if (root.val < firstMin) {
            secondMin = firstMin;
            firstMin = root.val;
        }
        if (root.val < secondMin && root.val != firstMin) {
            secondMin = root.val;
        }
        inorder(root.left);
        inorder(root.right);
    }
}
