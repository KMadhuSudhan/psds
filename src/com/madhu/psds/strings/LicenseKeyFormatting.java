package com.madhu.psds.strings;
//https://leetcode.com/problems/license-key-formatting/
//482. License Key Formatting

public class LicenseKeyFormatting {
    public static void main(String[] args) {
        String s = "2-4A0r7-4k";
        LicenseKeyFormatting licenseKeyFormatting = new LicenseKeyFormatting();
        System.out.println(licenseKeyFormatting.licenseKeyFormatting(s, 4));
    }

    public String licenseKeyFormatting(String S, int K) {
        char[] chars = S.toCharArray();
        int length = chars.length, i = 0;
        while (chars[i] != '-') {
            i++;
        }
        i++;
        int j = i;
        int k =0;
        while (i < length) {
            if (chars[i] != '-') {
                char nextChar = chars[i] >= 97 && chars[i] <= 122 ? (char) (chars[i] - 32) : chars[i];
                chars[j] = nextChar;
                k++;
                j++;
            }
            i++;
            if (k % K == 0 && chars[j]!='-' && i < length) {
                chars[j] = '-';
                j++;
            }
        }
        while (j<length) {
            chars[j++] = ' ';
        }
        return new String(chars).trim();
    }
}
