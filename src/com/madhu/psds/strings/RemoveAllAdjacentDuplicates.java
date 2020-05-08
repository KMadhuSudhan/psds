package com.madhu.psds.strings;
//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
//1209. Remove All Adjacent Duplicates in String II

public class RemoveAllAdjacentDuplicates {
    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        RemoveAllAdjacentDuplicates removeAllAdjacentDuplicates = new RemoveAllAdjacentDuplicates();
        System.out.println(removeAllAdjacentDuplicates.removeDuplicates(s,3));
    }

    public String removeDuplicates(String s, int k) {
        char[] sb = new char[s.length()];
        int[] dq = new int[s.length()];
        int sz=0;
        for(char ch: s.toCharArray()){
            dq[sz]= sz > 0 && sb[sz-1]==ch ? dq[sz-1]+1:1;
            sb[sz++]=ch;
            if(dq[sz-1]==k)  sz-=k;
        }
        return new String(sb,0,sz);
    }

    public String removeDuplicatesWith5Pecent(String s, int k) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean removedChars = true;
        int i=0;
        while(removedChars) {
            removedChars = false;
            sb = new StringBuilder();
            while(i < chars.length) {
                int size = 0;
                char currentChar = chars[i];
                while(i <chars.length && chars[i] == currentChar && size <k) {
                    i++;
                    size++;
                }
                if(size>=k) {
                    removedChars = true;
                } else {
                    sb.append(chars[i-size]);
                     i = i - size;
                     i++;
                }
            }
            chars = sb.toString().toCharArray();
            i=0;
        }
        return sb.toString();
    }
}
