package com.madhu.psds.trees;

import java.util.*;

public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.right =  new TreeNode(5);
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        Stack<TreeNode> stack = new Stack();
        List<String> paths = new ArrayList();
        binaryTreePaths.binaryTreePaths(node,stack,paths);
        binaryTreePaths.printArray(paths);
    }

    public void binaryTreePaths(TreeNode root,Stack<TreeNode> stack, List<String> paths) {
        if(root == null) return;
        stack.push(root);
        binaryTreePaths(root.left,stack,paths);
        if(root.left == null && root.right == null) {
            StringBuilder path = new StringBuilder();
            for(TreeNode node: stack) {
                path.append(node.val);
                path.append("->");
            }
            String modifiedPath = path.toString();
            if(!modifiedPath.isEmpty()) {
                modifiedPath = modifiedPath.substring(0, path.length() - 2);
                paths.add(modifiedPath);
            }
        }
        binaryTreePaths(root.right,stack,paths);
        stack.pop();
    }

    public void printArray(List<String> paths) {
        for (String path : paths) {
            System.out.print(" " + path);
        }
    }
}
