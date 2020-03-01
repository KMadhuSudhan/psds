package com.madhu.psds.trees;
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
//105. Construct Binary Tree from Preorder and Inorder Traversal

public class ConstructBinaryTreeFromPreorderAndInorder {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        ConstructBinaryTreeFromPreorderAndInorder constructBinaryTreeFromPreorderAndInorder = new ConstructBinaryTreeFromPreorderAndInorder();
        constructBinaryTreeFromPreorderAndInorder.buildTree(preorder,inorder);
    }


    class PreIndex {
        int index;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        PreIndex preIndex = new PreIndex();
        preIndex.index = 0;
        TreeNode root = buildTree(inorder, preorder, 0, inorder.length - 1, preIndex);
        return root;
    }


    public TreeNode buildTree(int[] inorder, int[] postorder, int inOrderStart, int inOrderEnd, PreIndex preIndex) {
        if(inOrderStart > inOrderEnd) return null;
        TreeNode root = new TreeNode(postorder[preIndex.index]);
        preIndex.index++;
        if (inOrderStart == inOrderEnd) return root;
        int index = search(inorder, inOrderStart, inOrderEnd,root.val);
        root.right = buildTree(inorder, postorder, index + 1, inOrderEnd,preIndex);
        root.left = buildTree(inorder, postorder, inOrderStart, index - 1,preIndex);
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
