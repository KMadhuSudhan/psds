package com.madhu.psds.strings;
//https://leetcode.com/problems/iterator-for-combination/
//1286. Iterator for Combination

import java.util.LinkedList;
import java.util.Queue;

public class IteratorForCombination {
    Queue<String> queue;

    IteratorForCombination(String characters, int combinationLength) {
        this.queue = new LinkedList();
        char[] arr = new char[combinationLength];
        char[] strArray = characters.toCharArray();
        backtrack(strArray, arr, 0, 0);
    }

    public static void main(String[] args) {
        IteratorForCombination iterator = new IteratorForCombination("abc", 2); // creates the iterator.
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public String next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public void backtrack(char[] strArray, char[] arr, int index, int ptr) {
        if (index == arr.length) {
            queue.offer(String.valueOf(arr));
            return;
        }
        for (int i = ptr; i < strArray.length; i++) {
            arr[index] = strArray[i];
            backtrack(strArray, arr, index + 1, i + 1);
        }
    }
}
