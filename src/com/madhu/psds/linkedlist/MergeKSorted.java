package com.madhu.psds.linkedlist;
//https://leetcode.com/problems/merge-k-sorted-lists/
//23. Merge k Sorted Lists

import java.util.PriorityQueue;

public class MergeKSorted {
    public static void main(String[] args) {
        MergeKSorted mergeKSorted = new MergeKSorted();

    }

    public ListNode mergeKListsWithoutHeap(ListNode[] lists) {
        int size = lists.length;
        if(size == 0) return null;
        if(size == 1) return lists[0];
        ListNode result = merge(lists[0],lists[1]);
        for (int i=2;i < size;i++) {
            result = merge(result,lists[i]);
        }
        return result;
    }

    public ListNode merge(ListNode l1,ListNode l2) {
        ListNode result = null;
        if(l1 == null) return l2;
        if(l2 == null ) return l1;
        if(l1.val <= l2.val) {
            result = l1;
            result.next = merge(l1.next,l2);
        } else {
            result = l2;
            result.next = merge(l1,l2.next);
        }
        return result;
    }


    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        if(size == 0) return null;
        if(size == 1) return lists[0];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(ListNode listNode: lists) {
            while (listNode!=null) {
                priorityQueue.add(listNode.val);
                listNode = listNode.next;
            }
        }
        if(priorityQueue.isEmpty()) return null;
        ListNode head = new ListNode(priorityQueue.poll());
        ListNode temp = head;
        while (!priorityQueue.isEmpty()) {
            temp.next = new ListNode(priorityQueue.poll());
            temp = temp.next;
        }
        return head;
    }

}
