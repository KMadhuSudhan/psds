package com.madhu.psds.trees;

import java.util.*;

public class VerticalOrderTraversal {
    public static void main(String[] args) {
        int[] nodes = new int[]{3,9,20,15,7};
        BST bst = new BST();
        bst.bulkInsert(nodes);
        VerticalOrderTraversal verticalOrderTraversal = new  VerticalOrderTraversal();
        verticalOrderTraversal.verticalTraversal(bst.root);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,List<Integer>> map = new TreeMap();
        int hd = 0;
        verticalTraversal(root,hd,map);
        List<List<Integer>> result = new ArrayList<>();
        for(Map.Entry<Integer,List<Integer>> entry: map.entrySet()) {
            List<Integer> value = entry.getValue();
            Collections.sort(value);
            result.add(value);
        }
        return result;
    }

    public void verticalTraversal(TreeNode root,int hd,TreeMap<Integer,List<Integer>> map) {
        if(root == null)
            return;
        List<Integer> vector = map.get(hd);
        if(vector == null) {
            vector = new ArrayList<>();
            vector.add(root.val);
        } else {
            vector.add(root.val);
        }
        map.put(hd,vector);
        verticalTraversal(root.left,hd-1,map);
        verticalTraversal(root.right,hd+1,map);
    }
}
