package com.madhu.psds.linkedlist;
//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
//83. Remove Duplicates from Sorted List

public class RemoveDuplicateFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode duplicate = head;
        while (current!=null && duplicate!=null) {
             while (duplicate!=null && current!=null && current.val == duplicate.val) {
                 duplicate = duplicate.next;
             }
            current.next = duplicate;
            current = duplicate;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        LinkedList linkedList = new LinkedList();
        linkedList.insert(nums);
        RemoveDuplicateFromSortedList removeDuplicateFromSortedList = new RemoveDuplicateFromSortedList();
        removeDuplicateFromSortedList.deleteDuplicates(linkedList.head);
    }
}
