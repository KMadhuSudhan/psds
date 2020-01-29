package com.madhu.psds.trees;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//337.https://leetcode.com/problems/house-robber-iii/
public class HouseRobber {
    private Map<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        int[] nodes = {3,2,3,3,1};
        HouseRobber houseRobber = new HouseRobber();
        BST bst = new BST();
        bst.bulkInsert(nodes);
        houseRobber.rob(bst.root);
    }

    public int rob(TreeNode root)
    {
        return postOrderTraversal(root)[0];
    }

    private int[] postOrderTraversal(TreeNode node)
    {
        if(node == null) return new int[] {0, 0};

        int[] left = postOrderTraversal(node.left);
        int[] right = postOrderTraversal(node.right);

        int first = Math.max(left[0]+right[0], node.val+left[1]+right[1]);
        int second = left[0] + right[0];

        return new int[] {first, second};
    }
}
