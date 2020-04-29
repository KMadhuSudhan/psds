package com.madhu.psds.trees;
//https://leetcode.com/problems/unique-binary-search-trees-ii/
//95. Unique Binary Search Trees II

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        UniqueBinarySearchTreesII uniqueBinarySearchTreesII = new UniqueBinarySearchTreesII();
        uniqueBinarySearchTreesII.generateTrees(3);
    }
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();
        return constructBsts(0,n);
    }

    public List<TreeNode> constructBsts(int start , int end) {
        List<TreeNode> list=new ArrayList<>();
        if(start>end) {
            list.add(null);
            return list;
        }
        for (int i=start;i<=end;i++) {
            List<TreeNode> leftSubTree = constructBsts(start,i-1);
            List<TreeNode> rightSubTree = constructBsts(i+1,end);
            for (int j=0;j<leftSubTree.size();j++) {
                for (int k=0;k<rightSubTree.size();k++) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftSubTree.get(j);
                    treeNode.right = rightSubTree.get(k);
                    list.add(treeNode);
                }
            }
        }
        return list;
    }
}
