package com.madhu.psds.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSum {

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum;
        int level = 0;
        int maxSum = 0;
        int maxLevel = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            sum = 0;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (maxSum < sum) {
                maxLevel = level;
                maxSum = sum;
            }
        }
        return maxLevel;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        int[] nodes = {1, 7, 0, 7, -8};
        bst.bulkInsert(nodes);
        MaximumLevelSum maximumLevelSum = new MaximumLevelSum();
        maximumLevelSum.maxLevelSum(bst.root);
    }
}
