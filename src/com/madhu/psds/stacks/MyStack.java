package com.madhu.psds.stacks;

import java.util.PriorityQueue;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    MyStack() {
        queue1  = new PriorityQueue<>();
        queue2 = new PriorityQueue<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue1.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        return queue1.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

}
