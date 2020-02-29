package com.madhu.psds.trees;
//https://leetcode.com/problems/n-ary-tree-level-order-traversal/submissions/
//429. N-ary Tree Level Order Traversal

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NarrayLevelOrder {
    public static void main(String[] args) {
        NarrayLevelOrder narrayLevelOrder = new NarrayLevelOrder();
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                Node node = queue.poll();
                level.add(node.val);
                for (int i = 0; i < node.children.size(); i++) {
                    queue.add(node.children.get(i));
                }
            }
            result.add(level);
        }
        return result;
    }
}
