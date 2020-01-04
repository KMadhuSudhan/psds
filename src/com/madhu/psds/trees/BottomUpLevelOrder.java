package com.madhu.psds.trees;

import java.util.*;

public class BottomUpLevelOrder {
    public static void main() {

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList();
        if(root == null) {
            return resultList;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        List<Integer> levelList =  new ArrayList();
        int size = 1;
        while(!q.isEmpty()) {
            TreeNode node = q.remove();
            if(node.left != null) {
                q.add(node.left);
            }
            if(node.right != null) {
                q.add(node.right);
            }
            levelList.add(node.val);
            if(--size == 0) {
                size = q.size();
                resultList.add(levelList);
                levelList = new ArrayList();
            }
        }
        Collections.reverse(resultList);
        return resultList;
    }
}
