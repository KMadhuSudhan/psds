package com.madhu.psds.trees;
//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
//230. Kth Smallest Element in a BST

import java.util.Stack;

public class KthSmallestElementInBST {
    public static void main(String[] args) {
        StringToNode stringToNode = new StringToNode();
        TreeNode root =  stringToNode.stringToTreeNode("3,1,4,null,2");
        KthSmallestElementInBST kthSmallestElementInBST = new KthSmallestElementInBST();
        kthSmallestElementInBST.kthSmallest(root,1);
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int kthSmall = 0;
        while (true) {
            if(root!=null) {
                stack.push(root);
                root = root.left;
            } else {
                if(stack.isEmpty()) break;
                TreeNode top = stack.pop();
                kthSmall++;
                if(kthSmall == k) return top.val;
                root = top.right;
            }
        }
        return -1;
    }
}
