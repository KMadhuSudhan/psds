package com.madhu.psds.trees;

public class Lca {
    public static void main(String[] args) {
        int[] nodes = new int[]{10, 5, 19, 1, 8, 17,21,6,9};
        BST bst = new BST();
        bst.bulkInsert(nodes);
        bst.print(bst.root);
        Lca lca = new Lca();
        System.out.println();
        TreeNode lcaNode = lca.findLCA(bst.root,8,11);
       int d1 = lca.findLevel(lcaNode,8,0);
       int d2 = lca.findLevel(lcaNode,11,0);
       System.out.print("distance: " +  (d1+ d2));
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
        return leftLca!=null? findLCA(root.left,v1,v2) : findLCA(root.right,v1,v2);
    }

    public int findLevel(TreeNode root, int a, int level)
    {
        if (root == null)
            return -1;
        if (root.val == a)
            return level;
        int left = findLevel(root.left, a, level + 1);
        if (left == -1)
            return findLevel(root.right, a, level + 1);
        return left;
    }
}
