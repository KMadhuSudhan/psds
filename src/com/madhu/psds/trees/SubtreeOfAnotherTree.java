package com.madhu.psds.trees;
//https://leetcode.com/problems/subtree-of-another-tree/
//572. Subtree of Another Tree

import java.util.ArrayList;
import java.util.List;

public class SubtreeOfAnotherTree {
    private static List<Integer> firstTreeInoder = new ArrayList<>();
    private static List<Integer> secondTreeInoder = new ArrayList<>();

    public static void main(String[] args) {
        SubtreeOfAnotherTree subtreeOfAnotherTree = new SubtreeOfAnotherTree();
        int[] nodes1 = {3, 4, 5, 1, 2};
        int[] nodes2 = {4, 1, 2};

        BST bst1 = new BST();
        BST bst2 = new BST();

        bst1.bulkInsert(nodes1);
        bst2.bulkInsert(nodes2);
        System.out.println(subtreeOfAnotherTree.isSubTree(bst1.root,bst2.root));
    }

    public boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;

        if (root1 == null)
            return false;
        if (isSameTree(root1, root2))
            return true;
        return isSubTree(root1.left, root2) ||
                isSubTree(root2.right, root2);
    }
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return true;
        return (root1.val == root2.val && (isSameTree(root1.left, root2) && isSameTree(root1.right, root2)));
    }
}
