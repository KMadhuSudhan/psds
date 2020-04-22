package com.madhu.psds.strings;
//https://leetcode.com/problems/isomorphic-strings
//205. Isomorphic Strings

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        IsomorphicString isomorphicString = new IsomorphicString();
        System.out.println(isomorphicString.isIsomorphic(s,t));
    }

    public boolean isIsomorphic(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int sLength = sChars.length;
        Map<Character,Character> mapping = new HashMap<>();
        Map<Character,Character> reverseMapping = new HashMap<>();
        for (int i=0;i<sLength;i++) {
            if(mapping.containsKey(sChars[i])) {
                if(mapping.get(sChars[i])!=tChars[i]) return false;
            } else {
                if(reverseMapping.containsKey(tChars[i])) return false;
                mapping.put(sChars[i], tChars[i]);
                reverseMapping.put(tChars[i],sChars[i]);
            }
        }
        return true;
    }
}
