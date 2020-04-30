package com.madhu.psds.linkedlist;
//https://leetcode.com/problems/rotate-list/
//61. Rotate List

public class RotateList {
    public static void main(String[] args) {
        RotateList rotateList = new RotateList();
        StringToLinkedList stringToLinkedList = new StringToLinkedList();
        ListNode  linkedList =  stringToLinkedList.stringToListNode("[1,2]");
        rotateList.rotateRight(linkedList,1);
    }


    public ListNode rotateRight(ListNode head, int k) {
        int length = findLength(head);
        if(k == 0 || length <= 1 || k % length == 0 ) return head;
        if(k > length) k = k % length;
        ListNode temp = head;
        ListNode node = head;
        ListNode prev = head;
        while(k>0&&temp!=null) {
            temp = temp.next;
            k--;
        }
        ListNode lastNode = head;
        while(temp!=null) {
            prev = temp;
            lastNode = node;
            node = node.next;
            temp = temp.next;
        }
        lastNode.next = null;
        prev.next = head;
        return node;
    }

    int findLength(ListNode root) {
        int length = 0;
        ListNode head = root;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }
}
