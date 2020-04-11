package com.madhu.psds.linkedlist;
//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/submissions/
//82. Remove Duplicates from Sorted List II

public class RemoveDuplicates {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next.next = new ListNode(5);
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        removeDuplicates.deleteDuplicates(listNode);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        while(head!=null && head.next!=null && head.val == head.next.val) {
            head = head.next;
        }
        if(temp!=head) {
            deleteDuplicates(head);
            head = head.next;
        }

        while (temp!=null && temp.next!=null) {
            ListNode next = temp.next;
            while(next!=null && next.next!=null && next.val == next.next.val) {
                next = next.next;
            }
            if(temp.next!=next) {
                temp.next = next.next;
            } else {
                temp = next;
            }
        }
        return head;
    }
}
