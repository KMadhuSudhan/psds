package com.madhu.psds.linkedlist;
//https://leetcode.com/problems/add-two-numbers-ii
//445. Add Two Numbers II

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbersII {
    int carry =0;
    ListNode next = null;
    ListNode result = null;
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(7);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(4);
        listNode1.next.next.next = new ListNode(3);
        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
//        ListNode listNode1 = new ListNode(5);
//        ListNode listNode2 = new ListNode(5);
        AddTwoNumbersII addTwoNumbersII = new AddTwoNumbersII();
        addTwoNumbersII.addTwoNumbers(listNode1,listNode2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Size = 0,l2Size= 0;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while (temp1!=null) {
            temp1 = temp1.next;
            l1Size++;
        }
        while (temp2!=null) {
            temp2 = temp2.next;
            l2Size++;
        }
        if(l1Size > l2Size) {
           l2 =  addZeros(l2,l1Size-l2Size);
        } else {
           l1 =  addZeros(l1,l2Size - l1Size);
        }
        addNumbers(l1,l2);
        if(carry > 0) {
            result = new ListNode(carry);
            if(next!=null) {
                result.next = next;
            }
        }
        return result;
    }
    public ListNode addZeros(ListNode list,int noOfZeros) {
        while (noOfZeros > 0) {
            ListNode listNode = new ListNode(0);
            listNode.next = list;
            list = listNode;
            noOfZeros--;
        }
        return list;
    }
    public void addNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return;
        int list1Val = l1.val;
        int list2Val = l2.val;
        addNumbers(l1.next,l2.next);
        int sum = carry + list1Val + list2Val;
        carry = sum > 9 ? 1 : 0;
        sum = sum %10;
        result = new ListNode(sum);
        if(next!=null) {
            result.next = next;
        }
        next = result;
    }

    public ListNode addTwoNumbersWithoutRecursion(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int l1Size = 0,l2Size=0,sum = 0,carry =0;
        while (l1!=null) {
            list1.add(l1.val);
            l1 = l1.next;
            l1Size++;
        }
        while (l2!=null) {
            list2.add(l2.val);
            l2 = l2.next;
            l2Size++;
        }
        l1Size--;l2Size--;
        ListNode result = null;
        ListNode next = null;

        while (l1Size >= 0 || l2Size >= 0) {
            int l1number = l1Size < 0 ? 0 : list1.get(l1Size);
            int l2number = l2Size < 0 ? 0 : list2.get(l2Size);
            sum = carry + l1number + l2number;
            carry = sum > 9 ? 1 : 0;
            sum = sum %10;
            result = new ListNode(sum);
            if(next!=null) {
                result.next = next;
            }
            next = result;
            l1Size--;l2Size--;
        }

        if(carry > 0) {
            result = new ListNode(carry);
            if(next!=null) {
                result.next = next;
            }
        }
        return result;
    }
}
