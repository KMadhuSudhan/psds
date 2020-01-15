package com.madhu.psds.strings;

public class IsSubsequence {
    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        String s = "abc";
        String t = "ahbgdc";
        isSubsequence.isSubsequence(s,t);
    }
    public boolean isSubsequence(String s, String t) {
        int slength = s.length();
        int tlength = t.length();
        if(slength == 0) return true;
        int sTrack = 0;
        int tTrack = 0;
        while(tTrack<tlength) {
            if(t.charAt(tTrack) == s.charAt(sTrack)) {
                sTrack++;
                if(sTrack == slength) {
                    return true;
                }
            }
            tTrack++;
        }
        return false;
    }
}
