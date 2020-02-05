package com.madhu.psds.trees;
//993 https://leetcode.com/problems/cousins-in-binary-tree/
public class CosuinsOfTree {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] nodes = {1,2,3,4};
        bst.bulkInsert(nodes);
        CosuinsOfTree cosuinsOfTree = new CosuinsOfTree();
        System.out.print(cosuinsOfTree.isCousins(bst.root,4,3));
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        int[] xLevelAndParent = findLevelAndParent(root, x, null, 0);
        int[] yLevelAndParent = findLevelAndParent(root, y, null, 0);
        if (xLevelAndParent[0] != Integer.MAX_VALUE && yLevelAndParent[0] != Integer.MAX_VALUE && xLevelAndParent[0] == yLevelAndParent[0]) {
            return xLevelAndParent[1] != yLevelAndParent[1];
        }
        return false;
    }

    public int[] findLevelAndParent(TreeNode root, int node, TreeNode parent, int level) {
        if (root == null) return new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        if (node == root.val) return new int[]{level, parent.val};
        int[] left = findLevelAndParent(root.left, node, root, 0);
        int[] right = findLevelAndParent(root.left, node, root, 0);
        if (left[0] != Integer.MAX_VALUE) return left;
        return right;
    }
}
