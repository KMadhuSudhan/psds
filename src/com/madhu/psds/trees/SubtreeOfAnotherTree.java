package com.madhu.psds.trees;

import java.util.ArrayList;
import java.util.List;

public class SubtreeOfAnotherTree {
    private static List<Integer> firstTreeInoder = new ArrayList<>();
    private static List<Integer> secondTreeInoder = new ArrayList<>();
    public static void main(String[] args) {
        SubtreeOfAnotherTree subtreeOfAnotherTree = new SubtreeOfAnotherTree();
        int[] nodes1 = {3,4,5,1,2};
        int[] nodes2 = {4,1,2};

        BST bst1 = new BST();
        BST bst2 = new BST();

        bst1.bulkInsert(nodes1);
        bst2.bulkInsert(nodes2);

        subtreeOfAnotherTree.inorder(bst1.root,firstTreeInoder);
        subtreeOfAnotherTree.inorder(bst2.root,secondTreeInoder);
        System.out.println(subtreeOfAnotherTree.isSubArray());
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }

    public boolean isSubArray() {
        int firstLength = firstTreeInoder.size();
        int secondLength = firstTreeInoder.size();
        int j =0;
        int i =0;
        while (i<firstLength && j  < secondLength) {
            if(firstTreeInoder.get(i) == firstTreeInoder.get(j)) {
                j++;
                if(j == secondLength) return true;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        return false;
    }
}
