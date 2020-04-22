package com.madhu.psds.linkedlist;

public class MyLinkedList {
    Node head;
    Node tail;
    int size;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= this.size) return -1;
        Node cur = this.head;
        for (int i=0; i<index; i++) cur = cur.next;
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (this.head == null) {
            this.head = new Node(val, null);
            this.tail = this.head;
        } else {
            this.head = new Node(val, this.head);
        }
        this.size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (this.tail == null) {
            this.tail = new Node(val, null);
            this.head = this.tail;
        } else {
            this.tail.next = new Node(val, null);
            this.tail = this.tail.next;
        }
        this.size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > this.size) return;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == this.size) {
            addAtTail(val);
            return;
        }
        Node cur = this.head;
        for (int i=0; i<index-1; i++) cur = cur.next;
        Node in = new Node(val, cur.next);
        cur.next = in;
        this.size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.size || this.size == 0) return;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
            this.size--;
            return;
        }
        if (index == 0) {
            this.head = this.head.next;
            this.size--;
            return;
        }
        Node cur = this.head;
        for (int i=0; i<index-1; i++) cur = cur.next;
        cur.next = cur.next.next;
        if (index == this.size-1) this.tail = cur;
        this.size--;
    }
    class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
