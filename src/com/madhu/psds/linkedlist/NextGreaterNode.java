package com.madhu.psds.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
//https://leetcode.com/problems/next-greater-node-in-linked-list/
public class NextGreaterNode {

    public static void main(String[] args) {
        NextGreaterNode nextGreaterNode = new NextGreaterNode();
        int[] nodes = new int[]{2, 1, 5};
        LinkedList linkedList = new LinkedList();
        linkedList.insert(nodes);
        nextGreaterNode.nextLargerNodes(linkedList.head);
    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        int nextGreaterElement = head.val;
        while (head.next != null) {
            if(head.val > nextGreaterElement) {
                while(temp!= head) {
                    list.add(head.val);
                    temp = temp.next;
                }
                if(temp.val!=nextGreaterElement) nextGreaterElement = temp.val;
            }
            head = head.next;
        }
        int[] nextLargerValues = new int[list.size()];
        int count = 0;
        for(int element: list) {
            nextLargerValues[count++] = element;
        }
        return nextLargerValues;
    }

    public int[] nextLargerNodesWithStack(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] nextLargerValues = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                nextLargerValues[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        return nextLargerValues;
    }
}
