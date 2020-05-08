package com.madhu.psds.strings;
//https://leetcode.com/problems/buddy-strings/submissions/
//859. Buddy Strings


import java.util.HashSet;
import java.util.Set;

public class BuddyString {
    public static void main(String[] args) {
        BuddyString buddyString = new BuddyString();
        String A = "ab";
        String B = "ab";
        buddyString.buddyStrings(A,B);
    }
    public boolean buddyStrings(String A, String B) {
        char[] aChars = A.toCharArray();
        char[] bChars = B.toCharArray();
        if(aChars.length == 0 ||  bChars.length == 0 || aChars.length!=bChars.length) return false;
        if(A.equals(B)) {
            Set<Character> set = new HashSet();
            for(int i=0;i<aChars.length;i++) {
                set.add(aChars[i]);
            }
            return set.size() != aChars.length;
        }
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < aChars.length; i++) {
            if (aChars[i] != bChars[i]) {
                a.append(aChars[i]);
                b.append(bChars[i]);
            }
        }
        if (a.length() == 2 && a.length() == b.length()) {
            return a.charAt(0) == b.charAt(1) && a.charAt(1) == b.charAt(0);
        }
        return false;
    }
}
