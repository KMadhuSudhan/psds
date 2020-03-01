package com.madhu.psds.trees;
//https://leetcode.com/problems/delete-leaves-with-a-given-value/submissions/
//1325. Delete Leaves With a Given Value

public class DeleteLeavesWithTarget {
    public static void main(String[] args) {
        StringToNode stringToNode = new StringToNode();
        TreeNode root = stringToNode.stringToTreeNode("[1,2,3,2,null,2,4]");
        DeleteLeavesWithTarget deleteLeavesWithTarget = new DeleteLeavesWithTarget();
        deleteLeavesWithTarget.removeLeafNodes(root, 2);
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null)
            return null;
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (root.val == target && root.left == null && root.right == null) {

            return null;
        }
        return root;
    }
}
