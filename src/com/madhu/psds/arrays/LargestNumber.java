package com.madhu.psds.arrays;
//https://leetcode.com/problems/largest-number/
public class LargestNumber {
    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        int[] nums = {10,2};
        largestNumber.largestNumber(nums);
    }
    public String largestNumber(int[] nums) {
        int temp=0;
        for(int x:nums)if(x!=0)temp=1;
        if(temp==0)return "0";
        mergesort(nums,0,nums.length-1);
        StringBuffer s=new StringBuffer();
        for(int x:nums){
            s.append(x);
        }
        return s.toString();
    }


    public void mergesort(int[] nums,int l,int r){
        if(l<r){
            int m = l+(r-l)/2;
            mergesort(nums,l,m);
            mergesort(nums,m+1,r);
            merge(nums,l,m,r);
        }
    }
    public void merge(int[] nums,int l,int m,int r){
        int n1 = m-l+1;
        int n2 = r-m;

        int[] L=new int[n1];
        int[] R=new int[n2];

        for(int i=0;i<n1;i++)L[i]=nums[l+i];
        for(int i=0;i<n2;i++)R[i]=nums[m+1+i];

        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
            if(compare(L[i],R[j])){
                nums[k] = L[i];
                i++;
            }
            else{
                nums[k] = R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            nums[k] = L[i];
            k++;
            i++;
        }
        while(j<n2){
            nums[k] = R[j];
            k++;
            j++;
        }
    }
    public boolean compare(int n1,int n2){
        StringBuffer a=new StringBuffer();
        a.append(n1);
        a.append(n2);
        StringBuffer b=new StringBuffer();
        b.append(n2);
        b.append(n1);
        return Long.parseLong(a.toString())>Long.parseLong(b.toString());
    }
}
