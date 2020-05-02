package com.madhu.psds.stacks;
//https://leetcode.com/problems/design-a-stack-with-increment-operation/submissions/
//1381. Design a Stack With Increment Operation
import java.util.LinkedList;
import java.util.ListIterator;

public class CustomStock {
    private int maxSize;
    private LinkedList<Integer> deque = new LinkedList<>();
    CustomStock(int maxSize) {
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (deque.size() != maxSize) {
            deque.addLast(x);
        }
    }

    public int pop() {
        if (!deque.isEmpty()) {
            return deque.pollLast();
        }
        return -1;
    }

    public void increment(int k, int val) {
        ListIterator<Integer> it = deque.listIterator();
        for (int i = 0; i < k && it.hasNext(); i++) {
            it.set(val + it.next());
        }
    }
}
