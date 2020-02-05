package com.madhu.psds.trees;

public class ConstructTreeFromPreAndPostOrder {
    int  preindex;
    public static void main(String[] args) {
//        int[] pre = {1,2,4,5,3,6,7};
//        int[] post = {4,5,2,6,7,3,1};
        int[] pre = {1};
        int[] post = {1};
        ConstructTreeFromPreAndPostOrder constructTreeFromPreAndPostOrder = new ConstructTreeFromPreAndPostOrder();
        TreeNode root =  constructTreeFromPreAndPostOrder.constructFromPrePost(pre,post,0,pre.length-1, pre.length);
        constructTreeFromPreAndPostOrder.inorder(root);
    }
    public TreeNode constructFromPrePost(int[] pre, int[] post,int l,int h,int size) {
        if(preindex >= size || l > h) return null;
        TreeNode root = new TreeNode(pre[preindex]);
        preindex++;
        if (l == h || preindex >= size)
            return root;
        int i;
        for (i=0;i<size;i++) {
            if(post[i] == pre[preindex]) {
                break;
            }
        }
        if(i<=h) {
            root.left = constructFromPrePost(pre, post, l, i, size);
            root.right = constructFromPrePost(pre, post, i + 1, h, size);
        }
        return root;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(" " + root.val);
        inorder(root.right);
    }
}
