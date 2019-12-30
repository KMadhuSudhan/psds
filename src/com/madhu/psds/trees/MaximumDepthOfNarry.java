package com.madhu.psds.trees;

public class MaximumDepthOfNarry {
    public int maxDepth(NaryTreeNode root) {
        if(root == null) return 0;
        int maxDepth = 0;
        for(NaryTreeNode children: root.children) {
            maxDepth = Math.max(maxDepth,maxDepth(children));
        }
        return 1 + maxDepth;
    }
}
