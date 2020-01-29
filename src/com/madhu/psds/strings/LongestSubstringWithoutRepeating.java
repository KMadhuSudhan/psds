package com.madhu.psds.strings;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        String s = "abcabcbb";
        LongestSubstringWithoutRepeating longestSubstringWithoutRepeating = new LongestSubstringWithoutRepeating();
        System.out.println(longestSubstringWithoutRepeating.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        int l = s.length();
        Set<Character> characters = new HashSet<>();
        while (i < l && j < l) {
            if (!characters.contains(s.charAt(j))) {
                characters.add(s.charAt(j));
                j++;
                max = Math.max(max, j - i);
            } else {
                characters.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}
