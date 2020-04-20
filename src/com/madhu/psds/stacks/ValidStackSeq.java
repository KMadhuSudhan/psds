package com.madhu.psds.stacks;
//https://leetcode.com/problems/validate-stack-sequences
//946. Validate Stack Sequences

public class ValidStackSeq {
    public static void main(String[] args) {
//        int[] pushed = {1,2,3,4,5};
//        int[] popped = {4,5,3,2,1};
//
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,3,5,1,2};

        ValidStackSeq validStackSeq = new ValidStackSeq();
        System.out.println(validStackSeq.validateStackSequences(pushed,popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i=0,j=0,pushLength = pushed.length,poppedLength=popped.length;
        int top = -1;
        int[] stack = new int[pushLength];
        while (i<pushLength && j < poppedLength) {
            stack[++top] = pushed[i++];
            while (top>=0 && stack[top] == popped[j]) {
                top--;j++;
            }
        }
        while (top>=0 && stack[top] == popped[j]) {
            top--;j++;
        }
        return top <0;
    }
}
