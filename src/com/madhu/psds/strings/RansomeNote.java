package com.madhu.psds.strings;

public class RansomeNote {

    public static void main(String[] args) {
        String str1 = "aa";
        String str2 = "aab";
        RansomeNote ransomeNote = new RansomeNote();
        ransomeNote.canConstruct(str1,str2);
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ransomNoteChar = ransomNote.toCharArray();
        char[] magazineChar = magazine.toCharArray();
        int ransomNoteLength = ransomNoteChar.length;
        int magazineLength = magazineChar.length;
        char[] charCount = new char[26];
        for(int i=0;i<ransomNoteLength;i++) {
            charCount[ransomNoteChar[i] -'a']++;
        }
        for(int i=0;i<magazineLength;i++) {
            if(charCount[magazineChar[i] - 'a'] == 0) return false;
            if(charCount[magazineChar[i] - 'a']-- < 0 ) return false;
        }
        return true;
    }
}
