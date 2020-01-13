package com.madhu.psds.strings;

public class DecryptString {
    public static void main(String[] args) {
        String s = "10#11#12";
        DecryptString decryptString = new  DecryptString();
        System.out.print(decryptString.freqAlphabets(s));
    }
    public String freqAlphabets(String s) {
        int length = s.length();
        String res = "";
        for(int i=0;i<length;i++) {
            if((i + 2) < length && s.charAt(i + 2) == '#') {
                char letter =  (char)('a' + (Integer.valueOf(s.substring(i, i + 2)) - 1));
                res+=letter;
                i+=2;
            } else {
                int number = Character.getNumericValue(s.charAt(i));
                char letter = (char)('a' + (number -1));
                res+=letter;
            }
        }
        return res;
    }
}
