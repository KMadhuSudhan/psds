package com.madhu.psds.trees;
//https://leetcode.com/problems/balance-a-binary-search-tree/
//1382. Balance a Binary Search Tree

import java.util.ArrayList;
import java.util.List;

public class BalanceABinarySearchTree {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        BST bst = new BST();
        bst.bulkInsert(nums);
        BalanceABinarySearchTree balanceABinarySearchTree = new BalanceABinarySearchTree();
        TreeNode treeNode =  balanceABinarySearchTree.balanceBST(bst.root);
        System.out.println(treeNode);
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return buildBalancedTree(list,0,list.size()-1);
    }

    public void inorder(TreeNode root,List<Integer> list) {
        if(root == null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }

    public TreeNode buildBalancedTree(List<Integer> list,int low,int high) {
      if(low>high) return null;
        int mid = (low + high)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildBalancedTree(list,low,mid-1);
        root.right = buildBalancedTree(list,mid+1,high);
        return root;
    }
}
