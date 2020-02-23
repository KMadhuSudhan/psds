package com.madhu.psds.strings;

public class MaximumSubString {

    String lexicographicalMaxString(String str) {
        // loop to find the max leicographic
        // substring in the substring array
        String mx = "";
        for (int i = 0; i < str.length(); ++i) {
            String subStr = str.substring(i);
            if (mx.compareTo(subStr) <= 0) {
                mx = subStr;
            }
        }

        return mx;
    }

    public static void main(String[] args) {
        String str = "ababaa";
        MaximumSubString maximumSubString = new MaximumSubString();
        maximumSubString.lexicographicalMaxString(str);
    }
}
