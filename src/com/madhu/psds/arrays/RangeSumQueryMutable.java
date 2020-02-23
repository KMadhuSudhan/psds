package com.madhu.psds.arrays;

public class RangeSumQueryMutable {
    int[] st;
    int[] nums;
    int n;

    public void NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        st = new int[max_size]; // Memory allocation
        buildST(nums, 0, n - 1, 0);
    }

    public int buildST(int[] nums, int ss, int se, int si) {
        if (ss == se) {
            st[si] = nums[ss];
            return st[si];
        }
        int mid = ss + (se - ss) / 2;
        st[si] = buildST(nums, ss, mid, 2 * si + 1) +  buildST(nums, mid + 1, se, 2 * si + 2);
        return st[si];
    }


    public void update(int i, int val) {
        if (i < 0 || i > n - 1) {
            System.out.println("Invalid Input");
            return;
        }

        int diff = val - nums[i];
        nums[i] = val;
        updateUtil(0, n - 1, i, diff, 0);
    }

    public void updateUtil(int ss,int se,int i,int diff,int index) {
        // Base Case: If the input index lies outside the range of this segment
        if(i < ss || i > se || index < ss || index > se) return;
        // If the input index is in range of this node, then update the value of the node and its children
        st[index] += diff;
        if(se!=ss) {
            int mid = ss + (ss - se)/2;
            updateUtil(ss, mid, i, diff, 2 * mid + 1);
            updateUtil(mid, se, i, diff, 2 * mid + 2);
        }
    }

    public int sumRange(int i, int j) {
        return sumRangeUtil(0, n - 1, i, j, 0);
    }

    public int sumRangeUtil(int ss, int se, int i, int j, int index) {
        //Full Overlap - query range is overlap segment range.
        if(i<= ss && j >= se ) {
            return st[index];
        }

        //No Overlap - query range out of segment range.
        if (se < i || ss > j)
            return 0;
        int mid = ss + (se -se)/2;
        return sumRangeUtil(ss, mid, i, j, 2 * index + 1) +
                sumRangeUtil(mid + 1, se, i, j, 2 * index + 2);
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        RangeSumQueryMutable rangeSumQueryMutable = new RangeSumQueryMutable();
        rangeSumQueryMutable.NumArray(nums);
    }
}
