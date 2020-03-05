package com.madhu.psds.trees;

import java.util.LinkedList;
import java.util.Queue;
//https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
//1315. Sum of Nodes with Even-Valued Grandparent

public class EvenValuedGrandparent {
    class GrandParent {
        TreeNode node;
        TreeNode parent;
        TreeNode grandParent;
    }

    int totalSum = 0;
    public static void main(String[] args) {
        EvenValuedGrandparent evenValuedGrandparent = new EvenValuedGrandparent();
    }

    public int sumEvenGrandparentWithCustomClass(TreeNode root) {
        if(root == null) return  0;
        GrandParent grandParent = new GrandParent();
        grandParent.node = root;
        Queue<GrandParent> queue = new LinkedList<>();
        queue.add(grandParent);
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- >0 ) {
                grandParent = queue.poll();

                if(grandParent.node.left!=null) {
                    GrandParent newGrandParent = new GrandParent();
                    newGrandParent.parent = grandParent.node;
                    newGrandParent.node = grandParent.node.left;
                    newGrandParent.grandParent = grandParent.parent;
                    if(grandParent.parent!=null && grandParent.parent.val %2 ==0) sum+= grandParent.node.left.val;
                    queue.add(newGrandParent);
                }
                if(grandParent.node.right!=null) {
                    GrandParent newGrandParent = new GrandParent();
                    newGrandParent.parent = grandParent.node;
                    newGrandParent.node = grandParent.node.right;
                    if(grandParent.parent!=null && grandParent.parent.val %2 ==0) sum+= grandParent.node.right.val;
                    newGrandParent.grandParent = grandParent.parent;
                    queue.add(newGrandParent);
                }
            }
        }
        return sum;
    }

    //recursive
    public int sumEvenGrandparent(TreeNode root) {
        return sumEvenGrandparent(root,null,null);
    }
    public int sumEvenGrandparent(TreeNode root,TreeNode parent,TreeNode grandParent) {
        if(root == null) return 0;
        if(grandParent!=null && grandParent.val%2 == 0) totalSum+=root.val;
        grandParent = parent;
        parent = root;
        sumEvenGrandparent(root.left,parent,grandParent);
        sumEvenGrandparent(root.right,parent,grandParent);
        return totalSum;
    }
}
