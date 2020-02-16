package com.madhu.psds.linkedlist;

//https://leetcode.com/problems/plus-one-linked-list/
//https://www.geeksforgeeks.org/add-1-number-represented-linked-list/
public class AddOneToLinkedList {
    static int carry = 1;
    static int sum = 0;

    public static void main(String[] args) {
        AddOneToLinkedList addOneToLinkedList = new AddOneToLinkedList();
        LinkedList linkedList = new LinkedList();
        int[] nodes = {1, 9, 9, 9};
        linkedList.insert(nodes);
        addOneToLinkedList.addOne(linkedList.head);
        if (carry != 0) {
            ListNode listNode = new ListNode(carry);
            listNode.next = linkedList.head;
            linkedList.head = listNode.next;
        }
        addOneToLinkedList.print(linkedList.head);
    }

    private void addOne(ListNode head) {
        if (head == null) {
            return;
        }
        addOne(head.next);
        sum = carry + head.val;
        head.val = sum%10;
        if (sum == 10) {
            head.val = 0;
            carry = 1;
        } else if (sum > 10) {
            head.val = sum - 10;
            carry = 1;
        } else {
            head.val = sum;
            carry = 0;
        }
    }

    private void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
