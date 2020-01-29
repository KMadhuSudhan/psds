package com.madhu.psds.trees;

class BST {
    public TreeNode root;

    /* Constructor */
    public BST() {
        root = null;
    }

    /* Function to check if tree is empty */
    public boolean isEmpty() {
        return root == null;
    }
    public void bulkInsert(int[] nodes) {
        for(int node: nodes) {
            insert(node);
        }
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    public TreeNode insert(TreeNode node, int data) {
        if (node == null)
            node = new TreeNode(data);
        else {
            if (data <= node.getData())
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }
    public void print(TreeNode node) {
        if(node == null) return;
        print(node.left);
        System.out.print(" " + node.val + " ");
        print(node.right);
    }
}
