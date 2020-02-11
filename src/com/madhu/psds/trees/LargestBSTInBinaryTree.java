package com.madhu.psds.trees;

public class LargestBSTInBinaryTree {
    public static void main(String[] args) {
        BST bst = new BST();
        LargestBSTInBinaryTree largestBSTInBinaryTree = new LargestBSTInBinaryTree();
        MinMax largest = largestBSTInBinaryTree.largest(bst.root);
    }

    private MinMax largest(TreeNode root) {
        if(root  == null) {
            return new MinMax();
        }
        MinMax left = largest(root.left);
        MinMax right = largest(root.right);

        MinMax m = new MinMax();

        if(left.isBST == false || right.isBST == false || left.max > root.val || right.min < root.val) {
            m.isBST = false;
            m.size = Math.max(left.size,right.size);
            return m;
        }

        m.isBST = true;
        m.size = left.size + right.size + 1;
        m.min = root.left!=null ? left.min : root.val;
        m.max = root.right!=null ? left.max : root.val;
       return m;
    }

    class MinMax {
        int min;
        int max;
        boolean isBST;
        int size;

        MinMax() {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            isBST = true;
            size = 0;
        }
    }
}
