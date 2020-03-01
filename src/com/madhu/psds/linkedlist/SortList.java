package com.madhu.psds.linkedlist;
//https://leetcode.com/problems/sort-list/
//148. Sort List

public class SortList {
    public static void main(String[] args) {
        SortList sortList = new SortList();
        //sortList.sortList();
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode middle = findMiddle(head);
        ListNode middleNext = middle.next;
        middle.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(middleNext);
        ListNode sortedList = sortedMerge(left,right);
        return sortedList;
    }
    ListNode sortedMerge(ListNode a,ListNode b) {
        ListNode result = null;
        if(a == null) {
            return b;
        }
        if(b == null) {
            return a;
        }
        if(a.val<=b.val) {
            result = a;
            result.next = sortedMerge(a.next,b);
        } else {
            result = b;
            result.next = sortedMerge(a,b.next);
        }
        return result;
    }


    public ListNode findMiddle(ListNode head) {
        if(head == null) return head;
        ListNode slowPtr = head,fastPtr = head;
        while (fastPtr.next!=null && fastPtr.next.next!=null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }
}
