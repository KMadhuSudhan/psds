package com.madhu.psds.arrays;
//https://leetcode.com/problems/additive-number/
//306. Additive Number

public class AdvantageShuffle {
    public static void main(String[] args) {
        int[] a = {2,7,11,15};
        int[] b = {1,10,4,11};
        AdvantageShuffle advantageShuffle = new AdvantageShuffle();
        int[] result =  advantageShuffle.advantageCount(a,b);
        advantageShuffle.print(result);
    }


    public int[] advantageCount(int[] A, int[] B) {
        BST bst = new BST();
        bst.bulkInsert(A);
        int length = A.length;
        int[] result = new int[length];
        for (int i=0;i< length;i++) {
            result[i] =  search(bst.root,B[i]);
        }
        return result;
    }

    public int search(TreeNode treeNode,int target) {
        if(treeNode.val < target) {
            search(treeNode.right,target);
        } else {
            return treeNode.right.val;
        }
        return -1;
    }

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            val = x;
        }
        public int getData() {
            return val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

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
    }

    public void print(int[] nums) {
        for (int num: nums) {
            System.out.println(num);
        }
    }
}
