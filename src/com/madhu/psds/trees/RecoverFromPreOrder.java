package com.madhu.psds.trees;
public class RecoverFromPreOrder {
    private int nodeStart = 0;
    private int current = 0;
    public static void main(String[] args) {
        String str = "1-2--3--4-5--6--7";
        RecoverFromPreOrder recoverFromPreOrder = new RecoverFromPreOrder();
        TreeNode root =  recoverFromPreOrder.recoverFromPreorder(str);
        recoverFromPreOrder.inorder(root);
    }

    public TreeNode recoverFromPreorder(String S) {
        if (S == null || S.length() == 0) return null;
        return recover(S);
    }

    private TreeNode recover(String s) {
        int nodeEnd = nodeStart;
        while (nodeEnd < s.length() && s.charAt(nodeEnd) != '-') nodeEnd++;
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(nodeStart, nodeEnd)));
        if (nodeEnd == s.length()) {
            current = 0;
            return root;
        }
        int temp = 0;
        while (s.charAt(nodeEnd) == '-') {
            temp++;
            nodeEnd++;
        }
        nodeStart = nodeEnd;
        int cp = Integer.compare(temp, current);
        current = temp;
        if (cp > 0) {
            root.left = recover(s);
            if (current == temp)
                root.right = recover(s);
        }
        return root;
    }

    public void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}
