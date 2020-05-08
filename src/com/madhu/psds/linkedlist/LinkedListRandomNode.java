package com.madhu.psds.linkedlist;
//https://leetcode.com/problems/linked-list-random-node/
//382. Linked List Random Node

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinkedListRandomNode {
    List<Integer> list = new ArrayList<>();
    Random random = new Random();
    public LinkedListRandomNode(ListNode head) {
        while (head != null) {

            list.add(head.val);
            head = head.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
