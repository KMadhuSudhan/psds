package com.madhu.psds.linkedlist;
//https://leetcode.com/problems/linked-list-in-binary-tree/submissions/
//1367. Linked List in Binary Tree

import com.madhu.psds.trees.TreeNode;

public class LinkedListInBinaryTree {
    public static void main(String[] args) {

    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null){
            return head == null;
        }
        return dfs(head,root) || isSubPath(head,root.left) || isSubPath(head,root.right);
    }

    public boolean dfs(ListNode head, TreeNode root) {
        if(head == null) return true;
        if(root == null || root.val!=head.val) return false;
        return dfs(head.next,root.left) || dfs(head.next,root.right);
    }
}
