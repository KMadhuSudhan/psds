package com.madhu.psds.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeafSummary {
    public static void main(String[] args) {
        int[] nodes = new int[]{3,5,1,6,2,9,8,7,4};
        BST bst = new BST();
        bst.bulkInsert(nodes);
        LeafSummary LeafSummary = new LeafSummary();
        System.out.println(LeafSummary.leafSimilar(bst.root,bst.root));
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> node1Leaves = getLeaves(root1);
        List<Integer> node2Leaves = getLeaves(root2);
        return node1Leaves.equals(node2Leaves);
    }

    private List<Integer> getLeaves(TreeNode root) {
        List<Integer> leaves = new ArrayList<>();
        if(root == null) return leaves;
        Stack<TreeNode> stack = new Stack<>();
        while (true){
            if(root!=null) {
                stack.push(root);
                root = root.left;
            } else {
                if(stack.isEmpty()) break;
                TreeNode popedNode = stack.pop();
                if(popedNode.right == null && popedNode.left == null) {
                    leaves.add(popedNode.val);
                }
                 root = popedNode.right;
            }
        }
        return leaves;
    }
}
