package com.madhu.psds.trees.narypreorder;

import com.madhu.psds.trees.NaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class NaryPreoder {
    public List<Integer> preorder(NaryTreeNode root) {
        List<Integer> result = new ArrayList();
        Stack<NaryTreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()) {
            NaryTreeNode poped = stack.pop();
            if(poped!=null) {
                result.add(poped.val);
                List<NaryTreeNode> childrens = poped.children;
                ListIterator<NaryTreeNode> listIterator = childrens.listIterator(childrens.size());
                while(listIterator.hasPrevious()) {
                    NaryTreeNode prev =  listIterator.previous();
                    if(prev !=null) {
                        stack.push(prev);
                    }
                }
            }
        }
        return result;
    }
}
