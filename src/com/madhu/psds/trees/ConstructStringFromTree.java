package com.madhu.psds.trees;

public class ConstructStringFromTree {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] nodes = {1,2,3,4};
        bst.bulkInsert(nodes);
        ConstructStringFromTree constructStringFromTree = new ConstructStringFromTree();
        System.out.println(constructStringFromTree.tree2str(bst.root));
    }
    public String tree2str(TreeNode t) {
        StringBuilder s = new StringBuilder();
        tree2str(t,s);
        return s.toString();
    }

    public void tree2str(TreeNode t,StringBuilder s) {
        if(t == null) return;
        s.append(t.val);
        if(t.left == null && t.right == null) {
            return;
        }
        s.append("(");
        tree2str(t.left,s);
        s.append(")");

        if(t.right !=null) {
            s.append("(");
            tree2str(t.right,s);
            s.append(")");
        }
    }

}
