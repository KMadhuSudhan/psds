package com.madhu.psds.trees;
//https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
//
public class LowestCommonAncestorOfDeepestLeaves {
    public class Pair{
        TreeNode node;
        int d;
        public Pair(TreeNode node, int d) {
            this.node  = node;
            this.d = d;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair p = getLca(root, 0);
        return p.node;
    }

    public Pair getLca(TreeNode node,int d) {
        if (node == null) return new Pair(null, d);
        Pair l = getLca(node.left, d + 1);
        Pair r = getLca(node.right, d + 1);
        if (l.d == r.d) return new Pair(node, l.d);
        if (l.d > r.d) return l;
        return r;
    }
}
