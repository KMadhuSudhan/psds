package com.madhu.psds.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//https://leetcode.com/problems/find-duplicate-subtrees/
//652. Find Duplicate Subtrees

public class FindDuplicateSubtrees {

    Map<String, Integer> duplicates = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs2("", root);
        return result;
    }

    public String dfs2(String value, TreeNode root){
        if(root == null) return "&";
        String s1 = dfs2(value, root.left);
        String s2 = dfs2(value, root.right);
        String inMap = root.val + s1 + s2;
        duplicates.put(inMap, duplicates.getOrDefault(inMap, 0) + 1);
        if(duplicates.get(inMap) == 2) result.add(root);
        return inMap;

    }
}
