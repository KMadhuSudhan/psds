package com.madhu.psds.trees;
//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
//106. Construct Binary Tree from Inorder and Postorder Traversal

public class ConstructBinaryTreeFromInorderAndPostOrder {
    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        ConstructBinaryTreeFromInorderAndPostOrder constructBinaryTreeFromInorderAndPostOrder = new ConstructBinaryTreeFromInorderAndPostOrder();
        constructBinaryTreeFromInorderAndPostOrder.buildTree(inorder, postorder);
    }

    class Index {
        int index;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Index pIndex = new Index();
        pIndex.index = postorder.length - 1;
        TreeNode root = buildTree(inorder, postorder, 0, inorder.length - 1, pIndex);
        return root;
    }


    public TreeNode buildTree(int[] inorder, int[] postorder, int inOrderStart, int inOrderEnd, Index pIndex) {
        if(inOrderStart > inOrderEnd) return null;
        TreeNode root = new TreeNode(postorder[pIndex.index]);
        pIndex.index--;
        if (inOrderStart == inOrderEnd) return root;
        int index = search(inorder, inOrderStart, inOrderEnd,root.val);
        root.right = buildTree(inorder, postorder, index + 1, inOrderEnd,pIndex);
        root.left = buildTree(inorder, postorder, inOrderStart, index - 1,pIndex);
        return root;
    }

    int search(int[] inorder, int start, int end, int target) {
        int i;
        for (i = start; i < end; i++) {
            if (inorder[i] == target) {
                break;
            }
        }
        return i;
    }
}
