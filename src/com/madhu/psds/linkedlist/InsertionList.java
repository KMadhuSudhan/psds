package com.madhu.psds.linkedlist;

public class InsertionList {
    private ListNode sorted;
    public static void main(String[] args) {
        InsertionList insertionList = new InsertionList();
        String str = "4->2->1->3";
        StringToLinkedList stringToIntegerArray = new StringToLinkedList();
        ListNode listNode =  stringToIntegerArray.stringToListNode(str);
        insertionList.insertionSortList(listNode);
    }

    public ListNode insertionSortList(ListNode head) {
        sorted = null;
        ListNode currNode = head;
        while (currNode!=null) {
            ListNode next = head.next;
            sortedInsert(currNode);
            currNode = next;
        }
        return sorted;
    }

    void sortedInsert(ListNode newNode){

        if(sorted == null || sorted.val>=newNode.val) {
            newNode.next = sorted;
            sorted = newNode;
        } else {
            ListNode current = sorted;
            while (current!=null && current.next.val < newNode.next.val ) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }
}
