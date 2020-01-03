package com.madhu.psds.number;

public class Palindrome {
    public static void main(String[] args) {
        Palindrome palindrome = new  Palindrome();
        System.out.println(palindrome.isPalindrome(121));
    }

    public boolean isPalindrome(int x) {
        if(x >= 0 && x < 9) return true;
        if(x < 0 || x%10 == 0 ) return false;
        int reverse = 0;
        int  n = x;
        while (x>0){
            int rem = x%10;
            reverse = reverse*10 + rem;
            x = x/10;
        }
        return n ==  reverse;
    }
}
