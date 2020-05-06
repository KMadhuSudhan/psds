package com.madhu.psds.trees;
//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/submissions/
//863. All Nodes Distance K in Binary Tree

import java.util.ArrayList;
import java.util.List;

public class AllNodesDistanceKInBinaryTree {
    List<Integer> result = new ArrayList();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        distanceKNodes(root,target,K);
        return result;
    }

    public int distanceKNodes(TreeNode root, TreeNode target, int K) {
        if(root == null) return -1;
        if(root == target) {
            getDownNodes(root,K);
            return 0;
        }
        int dl = distanceKNodes(root.left,target,K);
        if(dl!=-1) {
            if(dl + 1 == K) {
                result.add(root.val);
            } else {
                getDownNodes(root.right,K - dl -2);
            }
            return dl+1;
        }
        int dr = distanceKNodes(root.right,target,K);
        if (dr!=-1) {
            if(dr +1 == K) {
                result.add(root.val);
            } else {
                getDownNodes(root.left,K - dr -2);
            }
            return dr+1;
        }
        return -1;
    }

    public void getDownNodes(TreeNode root,int k) {
        if(root == null || k <0) return;
        if(k == 0) {
            result.add(root.val);
            return ;
        }
        getDownNodes(root.left,k-1);
        getDownNodes(root.right,k-1);
    }
}
