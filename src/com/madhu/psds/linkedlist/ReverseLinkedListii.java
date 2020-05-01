package com.madhu.psds.linkedlist;
//https://leetcode.com/problems/reverse-linked-list-ii/
//92. Reverse Linked List II

public class ReverseLinkedListii {
    public static void main(String[] args) {
        ReverseLinkedListii reverseLinkedListii = new ReverseLinkedListii();
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(n==m || head == null) return head;
        ListNode startNode = head;
        ListNode startPrev = head;
        int count = 1;
        while(startNode!=null && count < m) {
            startPrev = startNode;
            startNode = startNode.next;
            count++;
        }
        ListNode endNode = startNode;
        while(count < n && endNode!=null) {
            endNode = endNode.next;
            count++;
        }
        ListNode endNext = endNode.next;
        endNode.next = null;
        ListNode reversed =  reverseList(startNode);
        startPrev.next = reversed;
        startNode.next = endNext;
        return m==1 ? reversed : head;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
}
