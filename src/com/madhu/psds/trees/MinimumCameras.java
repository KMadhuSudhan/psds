package com.madhu.psds.trees;
//https://leetcode.com/problems/binary-tree-cameras/
//968. Binary Tree Cameras

public class MinimumCameras {
    int ans;
    private static final int NULL = 0;
    private static final int COVER = 1;
    private static final int CAMERA = 2;
    public static void main(String[] args) {
        String nodes = "[0,0,null,0,0,null,null,0,0]";
        StringToNode stringToNode = new StringToNode();
        TreeNode root =  stringToNode.stringToTreeNode(nodes);
        MinimumCameras minimumCameras = new MinimumCameras();
        //System.out.println( minimumCameras.minCameraCover(root));
        minimumCameras.inorder(root);
    }

    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        System.out.println(root.val + " ");
        inorder(root.left);
    }
    public int minCameraCover(TreeNode root) {
        if(root == null) return 0;
        ans = 0;
        if(dfs(root) == NULL) ans++;
        return ans;
    }


    int dfs(TreeNode root) {
        if(root == null) return COVER;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(left == NULL || right == NULL) {
            ans++;
            return CAMERA;
        }
        if(left == CAMERA || right == CAMERA) {
            return COVER;
        }
        return NULL;
    }
}
