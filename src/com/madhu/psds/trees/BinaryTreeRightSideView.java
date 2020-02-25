package com.madhu.psds.trees;
//https://leetcode.com/problems/binary-tree-right-side-view/
//199. Binary Tree Right Side View

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        int[] nums = {1,2,3,5,4};
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList();
        List<Integer> level = new ArrayList();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            /* iterate each level and add the last element of each level into the res */
            int size = q.size();
            while (size-- > 0) {
                TreeNode curr = q.poll();
                level.add(curr.val);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            res.add(level.get(level.size() - 1));
            level.clear();
        }
        return res;
    }
}
