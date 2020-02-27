package com.madhu.psds.trees;
//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/submissions/
//987. Vertical Order Traversal of a Binary Tree

import java.util.*;

public class VerticalOrderTraversal {
    class Node {
        int x;
        int y;
        TreeNode n;

        public Node(int x, int y, TreeNode n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }
    }

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, List<Node>> map = new HashMap<>();

        DFS(root, 0, 0, map);

        for (int i = min; i <= max; i++) {
            Collections.sort(map.get(i), (u, v) -> (u.y == v.y ? u.n.val - v.n.val : u.y - v.y));
            List<Integer> l = new ArrayList<>();
            for (Node n : map.get(i)) {
                l.add(n.n.val);
            }
            result.add(l);
        }

        return result;
    }

    private void DFS(TreeNode cur, int x, int y, Map<Integer, List<Node>> map) {
        if (cur == null)
            return;

        map.putIfAbsent(x, new ArrayList<>());
        map.get(x).add(new Node(x, y, cur));

        min = Math.min(x, min);
        max = Math.max(x, max);

        DFS(cur.left, x - 1, y + 1, map);
        DFS(cur.right, x + 1, y + 1, map);
    }
}
