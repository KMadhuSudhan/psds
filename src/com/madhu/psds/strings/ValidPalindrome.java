package com.madhu.psds.strings;

public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        ValidPalindrome validPalindrome = new ValidPalindrome();
        Character ch = ' ';
        System.out.println((int) ch);
        System.out.println(validPalindrome.isPalindrome(str));
    }
    public boolean isPalindrome(String s) {
        int i=0;
        int j= s.length() -1;
        char[] sChars = s.toCharArray();
        while (i<j) {
            while(i < j && (sChars[i] == 32 || !( (sChars[i] >=48 && sChars[i] <= 57) || (sChars[i] >=97 && sChars[i] <= 122) || (sChars[i] >=65 && sChars[i] <= 90)))) {
                i++;
            }
            while(j > i && (sChars[j] == 32 || !( (sChars[j] >=48 && sChars[j] <= 57) || (sChars[j] >=97 && sChars[j] <= 122) || (sChars[j] >=65 && sChars[j] <= 90)))) {
                j--;
            }
            //convert to uppercase
            if(!(sChars[i] >=65 && sChars[i] <= 90)) {
                sChars[i] = (char) ((sChars[i] - 'a') + 'A');
            }
            //convert to uppercase
            if(!(sChars[j] >=65 && sChars[j] <= 90)) {
                sChars[j] = (char) ((sChars[j] - 'a') + 'A');
            }
            if(sChars[i]!=sChars[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}
