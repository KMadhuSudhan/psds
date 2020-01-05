package com.madhu.psds.trees;

public class SumOfRootToLeaf {
    public static void main(String[] args) {
        int[] nodes = new int[]{1, 0, 1, 0, 1, 0, 1};
        BST bst = new BST();
        bst.bulkInsert(nodes);
        SumOfRootToLeaf sumOfRootToLeaf = new SumOfRootToLeaf();
        System.out.println( sumOfRootToLeaf.sumRootToLeaf(bst.root,0));
    }

    public int sumRootToLeaf(TreeNode root , int sum){
        sum=sum*2+root.val;
        if(root.left==null&&root.right==null){
            return sum;
        }else if(root.left==null){
            return sumRootToLeaf(root.right,sum);
        }else if(root.right==null){
            return sumRootToLeaf(root.left,sum);
        }else{
            return sumRootToLeaf(root.right,sum)+sumRootToLeaf(root.left,sum);
        }
    }
}
