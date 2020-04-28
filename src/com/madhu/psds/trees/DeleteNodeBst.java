package com.madhu.psds.trees;
//https://leetcode.com/problems/delete-node-in-a-bst/submissions/
//450. Delete Node in a BST

public class DeleteNodeBst {
    public static void main(String[] args) {
        DeleteNodeBst deleteNodeBst = new DeleteNodeBst();
        StringToNode stringToNode = new StringToNode();
        TreeNode root = stringToNode.stringToTreeNode("[5,3,6,2,4,null,7]");
        deleteNodeBst.deleteNode(root, 3);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(key < root.val) {
            root.left = deleteNode(root,key);
        } else if(key > root.val) {
            root.right = deleteNode(root,key);
        } else {
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            root.val = minValue(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    int minValue(TreeNode root) {
        while (root.left!=null) {
            root = root.left;
        }
        return root.val;
    }
}
