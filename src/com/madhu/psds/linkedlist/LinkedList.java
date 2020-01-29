package com.madhu.psds.linkedlist;

public class LinkedList {
    ListNode head;

    LinkedList() {
        head = null;
    }

    public void insert(int[] list) {
        for (int i = 0; i < list.length; i++) {
            if (head == null) {
                head = new ListNode(list[i]);
            } else {
                ListNode temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = new ListNode(list[i]);
            }
        }
    }

}
