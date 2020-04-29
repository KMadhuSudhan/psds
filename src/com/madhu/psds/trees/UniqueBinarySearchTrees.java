package com.madhu.psds.trees;
//https://www.geeksforgeeks.org/number-of-unique-bst-with-a-given-key-dynamic-programming/
//https://www.geeksforgeeks.org/total-number-of-possible-binary-search-trees-with-n-keys/
//Total number of possible Binary Search Trees with n different keys (countBST(n)) = Catalan number Cn = (2n)! / ((n + 1)! * n!)
//2nCn/n+1

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
        uniqueBinarySearchTrees.numTrees(3);
    }

    public int numTrees(int n) {
        if(n<=1) return 1;
        long catalanNo = binomialCoeff(2*n,n);

        return (int) (catalanNo/(long)(n+1));
    }

    long binomialCoeff(int n,int k) {
        long result = 1;
        if(k> n - k) {
            k = n-k;
        }
        for(int i=0;i<k;i++) {
            result*=(n-i);
            result/=(i+1);
        }
        return result;
    }
}
