package com.madhu.psds.trees;

public class SumOfLeftLeaves {
    public static void main(String[] args) {
        int[] nodes = {3,9,20,15,7};
        BST bst = new BST();
        bst.bulkInsert(nodes);
        SumOfLeftLeaves sumOfLeftLeaves = new SumOfLeftLeaves();
        sumOfLeftLeaves.sumOfLeftLeaves(bst.root);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = sum(root,null);
        return sum;
    }
    private int sum(TreeNode root,TreeNode parent){
        if(root == null) return 0;
        if(root.left == null && root.right == null && parent != null && parent.left == root){
            return root.val;
        }
        int left = sum(root.left,root);
        int right = sum(root.right,root);

        return left + right;
    }
}
