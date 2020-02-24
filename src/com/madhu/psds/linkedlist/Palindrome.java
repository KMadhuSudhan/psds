package com.madhu.psds.linkedlist;

public class Palindrome {
    public static void main(String[] args) {

    }

    void reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;
        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }

    void print(ListNode head) {
        if(head == null) return;
        while (head!=null) {
            System.out.println(head.val);
        }
    }
}
