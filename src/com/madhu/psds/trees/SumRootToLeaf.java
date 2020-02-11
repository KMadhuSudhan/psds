package com.madhu.psds.trees;


public class SumRootToLeaf {
    int sum = 0;
    public static void main(String[] args) {
        BST bst = new BST();
        int[] nodes = {1,2,3};
        bst.bulkInsert(nodes);
        SumRootToLeaf sumRootToLeaf = new SumRootToLeaf();
        sumRootToLeaf.sumNumbers(bst.root);
    }
    public int sumNumbers(TreeNode root) {
        sumNumbers(root,0);
        return sum;
    }

    public void sumNumbers(TreeNode root,int pathSum) {
        if(root == null) return;
        pathSum = pathSum*10 + root.val;
        if(root.left == null && root.right == null) {
            sum+=pathSum;
            pathSum = (pathSum - root.val)/10;
        }
        sumNumbers(root.left,pathSum);
        sumNumbers(root.right,pathSum);
    }
}
