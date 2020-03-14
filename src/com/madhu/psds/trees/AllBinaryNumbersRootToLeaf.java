package com.madhu.psds.trees;

import java.util.ArrayList;
import java.util.List;

public class AllBinaryNumbersRootToLeaf {
    List<String> result = new ArrayList();
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        AllBinaryNumbersRootToLeaf allBinaryNumbersRootToLeaf = new AllBinaryNumbersRootToLeaf();
        StringToNode stringToNode = new StringToNode();
        String str = "[1,0,1,1,1,0,1,1,0,1,null,1,null,null,1]";
        TreeNode root = stringToNode.stringToTreeNode(str);
        allBinaryNumbersRootToLeaf.getAllPaths(root);
        allBinaryNumbersRootToLeaf.print();
    }

    void getAllPaths(TreeNode root) {
        if(root ==null) return;
        sb = sb.append(root.val);
        if(root.left == null || root.right == null) {
            result.add(sb.toString());
        }
        getAllPaths(root.left);
        getAllPaths(root.right);
        String str = sb.substring(0,sb.length() - 1);
        sb = new StringBuilder(str);
    }

    void print() {
        for(String str: result) {
            System.out.println(str);
        }
    }
}
