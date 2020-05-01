package com.madhu.psds.linkedlist;
//https://leetcode.com/problems/reorder-list/submissions/
//143. Reorder List

import java.util.ArrayList;
import java.util.List;

public class ReorderList {
    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();

    }
    public void reorderList(ListNode head) {
        if(head == null) return;
        List<ListNode> listNodeList = new ArrayList<>();
        ListNode temp = head;
        while (temp!=null) {
            listNodeList.add(temp);
            temp = temp.next;
        }
        int start = 0;
        int end = listNodeList.size()-1;
        while (start<end) {
            listNodeList.get(start).next = listNodeList.get(end);
            listNodeList.get(end).next = listNodeList.get(start+1);
            start++;
            end--;
        }
        listNodeList.get(start).next = null;
    }
}
