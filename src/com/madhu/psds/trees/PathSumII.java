package com.madhu.psds.trees;

//https://leetcode.com/problems/path-sum-ii/
//113. Path Sum II

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public static void main(String[] args) {

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        // Approach - similar logic to Path Sum 1 solution, except instead of returning boolean, we write result to the list and keep looking through the entire tree.
        // also need to keep track of each parent/ancestor node.

        int runningSum = 0;

        //result ArrayList
        ArrayList<List<Integer>> allPaths = new ArrayList<>();

        ArrayList<Integer> curr = new ArrayList<>();

        checkPaths(root, sum, runningSum, allPaths, curr);

        return allPaths;

    }

    public void checkPaths(TreeNode root, int sum, int running, ArrayList<List<Integer>> res, ArrayList<Integer> curr) {

        //
        if (root != null) {
            // add to curr
            curr.add(root.val);


            // check if equal to sum, in addition to runningSum
            running += root.val;
            //System.out.println(running);
            if (running == sum && (root.left == null) && (root.right == null)) {
                // we've found a valid pathSum, add to the result array
                //System.out.println(running);
                //System.out.println(sum);
                ArrayList<Integer> thisRes = new ArrayList<>();
                thisRes.addAll(curr);
                res.add(thisRes);

                // reset list
                curr.remove(curr.size() - 1);
            } else {
                // need to go to the right and to the left
                checkPaths(root.left, sum, running, res, curr);
                checkPaths(root.right, sum, running, res, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
