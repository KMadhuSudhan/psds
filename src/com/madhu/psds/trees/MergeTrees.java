package com.madhu.psds.trees;

import com.madhu.psds.trees.TreeNode;

public class MergeTrees {
    public static void main(String[] args) {
        System.out.print("Merge nodes");
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}