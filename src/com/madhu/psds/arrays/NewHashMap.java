package com.madhu.psds.arrays;

public class NewHashMap {

    private Node[] nodes;
    private int capacity = 1 << 9;
    /** Initialize your data structure here. */
    public NewHashMap() {
        nodes = new Node[capacity];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key & (capacity - 1);
        if (nodes[index] == null) {
            nodes[index] = new Node(key, value);
            return;
        }
        Node p = nodes[index];
        while (p != null) {
            if (p.key == key) {
                p.value = value;
                return;
            }
            p = p.next;
        }
        Node cur = new Node(key, value);
        cur.next = nodes[index];
        nodes[index] = cur;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key & (capacity - 1);
        Node p = nodes[index];
        while (p != null) {
            if (p.key == key) {
                return p.value;
            }
            p = p.next;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key & (capacity - 1);
        if (nodes[index] == null) {
            return;
        }
        if (nodes[index].key == key) {
            nodes[index] = nodes[index].next;
            return;
        }
        Node pre = nodes[index];
        Node cur = pre.next;
        while (cur != null) {
            if (cur.key == key) {
                pre.next = cur.next;
                return;
            }
            pre = cur;
            cur = pre.next;
        }
    }
    private static class Node {
        int key;
        int value;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
