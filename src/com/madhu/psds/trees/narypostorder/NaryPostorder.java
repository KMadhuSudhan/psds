package com.madhu.psds.trees.narypostorder;

import com.madhu.psds.trees.NaryTreeNode;
import com.madhu.psds.trees.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class NaryPostorder {

    public List<Integer> postorder(NaryTreeNode root) {
        LinkedList<NaryTreeNode> stack = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            NaryTreeNode pop = stack.pollLast();
            if(pop!=null) {
                result.addFirst(pop.val);
                List<NaryTreeNode> children = pop.children;
                for(NaryTreeNode node: children) {
                    stack.add(node)  ;
                }
            }
        }
        return result;
    }
}
