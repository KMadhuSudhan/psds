package com.madhu.psds.linkedlist;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode temp = head;
        while(temp!=null) {
            if(val == temp.val) {
                if(prev == null) {
                    head = head.next;
                    temp = head;
                    continue;
                }
                prev.next = temp.next;
                temp = prev.next;
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }
}
