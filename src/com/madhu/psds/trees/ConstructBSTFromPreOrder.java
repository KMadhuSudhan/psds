package com.madhu.psds.trees;

import java.util.Stack;

class Index {
    int index = 0;
}

public class ConstructBSTFromPreOrder {

    public static void main(String[] args) {
        int[] nodes = {10, 5, 1, 7, 40, 50};
        ConstructBSTFromPreOrder constructBSTFromPreOrder = new ConstructBSTFromPreOrder();
//        Index index = new Index();
//        TreeNode root = constructBSTFromPreOrder.constructBST(nodes, index, nodes[0], Integer.MIN_VALUE, Integer.MAX_VALUE, nodes.length);
//        constructBSTFromPreOrder.inorder(root);
        TreeNode root = constructBSTFromPreOrder.constructBSTIterative(nodes, nodes.length);
        constructBSTFromPreOrder.inorder(root);
    }

    public TreeNode constructBST(int[] nodes, Index preIndex, int key, int min, int max, int size) {
        if (preIndex.index >= size) return null;
        TreeNode root = null;
        if (key > min && key < max) {
            root = new TreeNode(key);
            preIndex.index = preIndex.index + 1;
            if (preIndex.index < size) {
                root.left = constructBST(nodes, preIndex, nodes[preIndex.index], min, key, size);
                if (preIndex.index < size) {
                    root.right = constructBST(nodes, preIndex, nodes[preIndex.index], key, max, size);
                }
            }
        }
        return root;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(" " + root.val);
        inorder(root.right);
    }

    public TreeNode constructBSTIterative(int[] nodes, int size) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(nodes[0]);
        stack.push(root);
        for (int i = 1; i < size; i++) {
            TreeNode temp = null;
            while (!stack.empty() && nodes[i] > stack.peek().val) {
                temp = stack.pop();
            }
            if (temp != null) {
                temp.right = new TreeNode(nodes[i]);
                stack.push(temp.right);
            } else {
                temp = stack.peek();
                temp.left = new TreeNode(nodes[i]);
                stack.push(temp.left);
            }
        }
        return root;
    }
}
