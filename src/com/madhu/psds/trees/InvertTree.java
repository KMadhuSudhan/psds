package com.madhu.psds.trees;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {

    public static void main() {
        InvertTree invertTree = new InvertTree();
        int[] nodes = new int[]{4, 2, 7, 1, 3, 6, 9};
        BST bst = new BST();
        bst.bulkInsert(nodes);
        invertTree.invertTree(bst.root);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }
}
