package com.madhu.psds.trees;

import java.util.*;

public class AverageLevels {
    public static void main(String[] args) {
        AverageLevels averageLevels = new AverageLevels();
        int[] nodes = new int[]{2147483647,2147483647,2147483647};
        BST bst = new BST();
        bst.bulkInsert(nodes);
        averageLevels.averageOfLevels(bst.root);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> levelAvg = new ArrayList<>();
        if(root == null) {
            return levelAvg;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        long sum = 0;
        int size = 1, n = 1;
        while(!q.isEmpty()) {
            TreeNode node = q.remove();
            if(node.left != null) {
                q.add(node.left);
            }
            if(node.right != null) {
                q.add(node.right);
            }
            sum += node.val;
            if(--size == 0) {
                size = q.size();
                levelAvg.add((double)sum/n);
                sum = 0;
                n = size;
            }
        }
        return levelAvg;
    }
}
