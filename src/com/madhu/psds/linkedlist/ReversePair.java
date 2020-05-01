package com.madhu.psds.linkedlist;
//https://leetcode.com/problems/swap-nodes-in-pairs/submissions/
//24. Swap Nodes in Pairs

public class ReversePair {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p=head,q=head.next;
        p.next = q.next;
        q.next = p;
        p.next = swapPairs(p.next);
        return q;
    }
}
