package com.madhu.psds.trees;

public class Lca {
    public static void main(String[] args) {
        int[] nodes = new int[]{4, 2, 3, 1, 7, 6};
        BST bst = new BST();
        bst.bulkInsert(nodes);
        Lca lca = new Lca();
        lca.findLCA(bst.root,1,7);
    }

    public TreeNode findLCA(TreeNode root, int v1, int v2) {
        if(root == null) {
            return null;
        }
        if(root.val == v1 || root.val == v2) {
            return root;
        }
        TreeNode leftLca =  findLCA(root.left,v1,v2);
        TreeNode rightLca =  findLCA(root.right,v1,v2);

        if(leftLca!=null&&rightLca!=null) {
            return root;
        }
        return leftLca!=null? leftLca: rightLca;
    }
}
