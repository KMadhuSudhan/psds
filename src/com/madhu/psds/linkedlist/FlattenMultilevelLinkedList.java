package com.madhu.psds.linkedlist;
//https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
//430. Flatten a Multilevel Doubly Linked List


import java.util.Stack;

public class FlattenMultilevelLinkedList {
    public static void main(String[] args) {
        FlattenMultilevelLinkedList flattenMultilevelLinkedList = new FlattenMultilevelLinkedList();
        MutlilevelDoubleLinkedList mutlilevelDoubleLinkedList = new MutlilevelDoubleLinkedList(1);
        mutlilevelDoubleLinkedList.next = new MutlilevelDoubleLinkedList(3);
        mutlilevelDoubleLinkedList.next.next = new MutlilevelDoubleLinkedList(4);
        mutlilevelDoubleLinkedList.next.child = new MutlilevelDoubleLinkedList(7);
        mutlilevelDoubleLinkedList.next.child.next = new MutlilevelDoubleLinkedList(8);
        mutlilevelDoubleLinkedList.next.child.next.next = new MutlilevelDoubleLinkedList(9);
        mutlilevelDoubleLinkedList.next.child.next.child = new MutlilevelDoubleLinkedList(11);
        mutlilevelDoubleLinkedList.next.child.next.child.next = new MutlilevelDoubleLinkedList(12);
        mutlilevelDoubleLinkedList.next.child.next.child.next = new MutlilevelDoubleLinkedList(12);
        mutlilevelDoubleLinkedList.next.child.next.next.next = new MutlilevelDoubleLinkedList(10);
        flattenMultilevelLinkedList.flatten(mutlilevelDoubleLinkedList);
    }
    public MutlilevelDoubleLinkedList flatten(MutlilevelDoubleLinkedList head) {
        MutlilevelDoubleLinkedList temp = head;
        Stack<MutlilevelDoubleLinkedList> stack = new Stack();
        while(temp!=null) {
            if(temp.child!=null) {
                stack.push(temp.next);
                temp.child.prev = temp;
                temp.next = temp.child;
                temp.child = null;
            } else if(!stack.isEmpty() && temp.next == null ) {
                MutlilevelDoubleLinkedList pop = stack.pop();
                pop.prev = temp;
                temp.next = pop;
            }
            temp = temp.next;
        }
        return head;
    }
}
