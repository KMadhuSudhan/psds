package com.madhu.psds.linkedlist;

public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode temp = head;
        while(temp!=null) {
            count++;
            temp = temp.next;
        }
        int nthNode = count - n + 1;
        count = 0;
        temp = head;
        ListNode prev = null;
        while((count + 1) < nthNode) {
            count++;
            prev = temp;
            temp = temp.next;
        }
        if(count == 0) {
            head = head.next;
            return head;
        }
        prev.next =  temp.next;
        return head;
    }
}
