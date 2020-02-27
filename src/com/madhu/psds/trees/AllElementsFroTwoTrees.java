package com.madhu.psds.trees;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
//1305. All Elements in Two Binary Search Trees

public class AllElementsFroTwoTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList();
        List<Integer> l2 = new ArrayList();
        inOrder(root1, l1);
        inOrder(root2, l2);
        return merge(l1, l2);
    }

    public static void inOrder(TreeNode root, List<Integer> l) {
        if(root == null) return;
        inOrder(root.left, l);
        l.add(root.val);
        inOrder(root.right, l);
        return;
    }

    public static List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        List<Integer> ans = new ArrayList();
        int i1 = 0, i2 = 0;
        while (i1 < l1.size() && i2 < l2.size()){
            if (l1.get(i1) <= l2.get(i2)) {
                ans.add(l1.get(i1++));
            } else {
                ans.add(l2.get(i2++));
            }
        }
        ans.addAll(i1 < l1.size() ? l1.subList(i1, l1.size()) : l2.subList(i2, l2.size()));
        return ans;
    }
}
