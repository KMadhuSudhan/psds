package com.madhu.psds.strings;

public class StringPermutation {
    public static void main(String[] args) {
        String str = "abcd";
        char[] strChars = str.toCharArray();
        int length = str.length();
        StringPermutation stringPermutation = new StringPermutation();
        stringPermutation.permutations(strChars,0,length-1);
    }

    public void permutations(char[] strChars ,int start,int length) {
        if(start == length) {
            System.out.println(new String(strChars));
        } else {
            for (int i=start;i<=length;i++) {
                swap(strChars,start,i);
                permutations(strChars,start+1,length);
                swap(strChars,start,i);
            }
        }
    }
    private void swap(char[] strChars,int i,int j) {
        char temp = strChars[i];
        strChars[i] = strChars[j];
        strChars[j] = temp;
    }
}
