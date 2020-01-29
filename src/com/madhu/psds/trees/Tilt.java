package com.madhu.psds.trees;

import java.util.LinkedList;
import java.util.Queue;

public class Tilt {
    static int ret = 0;
    public static void main(String[] args) {
        int[] nodes = {5,2,3,7,9,6,1};
        Tilt tilt = new Tilt();
        TreeNode treeNode =  tilt.arrayToTreeNode(nodes);
       System.out.println(tilt.findTilt(treeNode));
    }

    public int findTilt(TreeNode root) {
        if(root==null){
            return 0;
        }
        int l = find(root.left);
        int r = find(root.right);
        ret = ret+Math.abs(l-r);
        return ret;
    }

    public int find(TreeNode root){
        if(root==null){
            return 0;
        }
        int l = find(root.left);
        int r = find(root.right);
        ret = ret+Math.abs(l-r);
        return (root.val+l+r);
    }

    public TreeNode arrayToTreeNode(int[] input) {
        if (input.length == 0) {
            return null;
        }

        int item = input[0];
        TreeNode root = new TreeNode(item);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == input.length) {
                break;
            }

            item = input[index++];
            int leftNumber = item;
            node.left = new TreeNode(leftNumber);
            nodeQueue.add(node.left);

            if (index == input.length) {
                break;
            }

            item = input[index++];
                int rightNumber = item;
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
        }
        return root;
    }

}
