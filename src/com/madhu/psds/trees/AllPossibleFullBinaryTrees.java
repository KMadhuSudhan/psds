package com.madhu.psds.trees;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/all-possible-full-binary-trees/
public class AllPossibleFullBinaryTrees {

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> ans = new ArrayList<>();
        if (N % 2 == 0) return ans;
        if (N == 1) {
            ans.add(new TreeNode(0));
            return ans;
        }
        for (int i = 1; i < N; i += 2) {
            for (TreeNode l : allPossibleFBT(i))
                for (TreeNode r : allPossibleFBT(N - i - 1)) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
        }
        return ans;
    }
}
