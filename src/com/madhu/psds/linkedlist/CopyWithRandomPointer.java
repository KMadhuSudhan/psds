package com.madhu.psds.linkedlist;
//https://leetcode.com/problems/copy-list-with-random-pointer/
//138. Copy List with Random Pointer


public class CopyWithRandomPointer {
    class RandomPointer {
       Node node;
       int index;
       public RandomPointer(Node node,int index) {
           this.node = node;
           this.index = index;
       }
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {

    }
}
