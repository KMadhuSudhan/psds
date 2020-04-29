package com.madhu.psds.trees;
//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
//109. Convert Sorted List to Binary Search Tree

import com.madhu.psds.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree {
    ListNode head;
    public static void main(String[] args) {
        ConvertSortedListToBinarySearchTree convertSortedListToBinarySearchTree = new ConvertSortedListToBinarySearchTree();

    }

    //1 ms, faster than 40.69% of Java online submissions for Convert Sorted List to Binary Search Tree.
    public TreeNode sortedListToBSTWithouLen(ListNode head) {
        if(head == null) return null;
        List<Integer> list = getList(head);
        return convertToBst(list,0,list.size()-1);
    }
    public TreeNode convertToBst(List<Integer> list,int low,int high) {
        if(low>high) return null;
        int mid = low + (high - low)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = convertToBst(list,low,mid-1);
        root.right = convertToBst(list,mid+1,high);
        return root;
    }
    List<Integer> getList(ListNode head) {
        List<Integer> list = new ArrayList();
        while(head!=null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted List to Binary Search Tree.

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        this.head = head;
        return buildBst(length(head));
    }
    public TreeNode buildBst(int len) {
        if(len == 0) return null;
        TreeNode leftNode = buildBst(len/2);
        TreeNode root = new TreeNode(head.val);
        head = head.next;
        root.left = leftNode;
        root.right = buildBst(len-len/2-1);
        return root;
    }

    public int length(ListNode node) {
        int length = 0;
        while(node!=null) {
            length++;
            node = node.next;
        }
        return length;
    }
}
