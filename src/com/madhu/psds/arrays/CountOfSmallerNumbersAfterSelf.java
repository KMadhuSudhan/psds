package com.madhu.psds.arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf countOfSmallerNumbersAfterSelf = new CountOfSmallerNumbersAfterSelf();
        int[] nums = {5,2,6,1};
        countOfSmallerNumbersAfterSelf.countSmaller(nums);
    }

    public List<Integer> countSmaller(int[] nums) {
        int length = nums.length;
        Integer[] res = new Integer[length];
        List<Integer> result = new ArrayList<>();
        for (int i=length-1;i>=0;i--) {
            insert(result,res,nums[i],i);
        }
        return Arrays.asList(res);
    }

    public void insert(List<Integer> result,Integer[] res,int num,int i) {
        int low = 0;
        int high = result.size()-1;
        while(low<=high) {
            int mid = (low + high)/2;
            int M = result.get(mid);
            if(M >= num) {
                high = mid -1;
            } else {
                low = mid  +1;
            }
        }
        res[i] = low;
        result.add(low,num);
    }

    public List<Integer> countSmallerBst(int[] nums) {
        int n = nums.length;
        List<Integer> res = Arrays.asList(new Integer[n]);
        if (n == 0) return res;

        // initialize the end node
        res.set(n-1, 0);
        Node root = new Node(nums[n-1]);

        // traverse from right to left O(n)
        for (int i = n-2; i >= 0; i--) {
            int current = nums[i];

            // track how many values current is greater than
            int gtCount = 0;

            // BST insertion, find parent and count nodes O(log(n))
            Node child = root;
            Node parent = null;
            while (child != null) {
                parent = child;
                if (current < child.val) {
                    // child is greater than this value
                    child.gtCount++;
                    child = child.left;
                } else {
                    // current is greater than all of child's gtCount
                    gtCount += child.gtCount;
                    if (current > child.val) gtCount += 1;
                    child = child.right;
                }
            }

            // insert current node
            if (parent.val > current) {
                parent.left = new Node(current);
            } else {
                parent.right = new Node(current);
            }

            // build result
            res.set(i, gtCount);
        }

        return res;
    }

    class Node {
        Node right, left;
        int val, gtCount;

        public Node(int val) {
            this.val = val;
            this.gtCount = 0;
        }
    }
}
