package com.madhu.psds.strings;
//https://leetcode.com/problems/valid-palindrome-ii/
//680. Valid Palindrome II

public class ValidPalindromeII {
    public static void main(String[] args) {
        String str = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        ValidPalindromeII validPalindromeII = new ValidPalindromeII();
        System.out.println(validPalindromeII.validPalindrome(str));
    }
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
       return validPalindrome(chars,0,length-1,true);
    }

    public boolean validPalindrome(char[] chars,int start,int end,boolean allowed) {
        while (start<end) {
            if(chars[start]!=chars[end]) {
                return allowed ? (validPalindrome(chars,start,end-1,false)
                        || validPalindrome(chars,start+1,end,false))  :false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}
