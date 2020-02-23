package com.madhu.psds.strings;

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
       char[] charCount = new char[26];
       char[] sChars = s.toCharArray();
       int length = sChars.length;
       for(int i=0;i<length;i++) {
           charCount[sChars[i] - 'a']++;
       }
       for(int i=0;i<length;i++) {
           if(charCount[sChars[i] - 'a'] == 0) return i;
       }
       return -1;
    }
    public static void main(String[] args) {
        String str = "loveleetcode";
        FirstUniqueCharacter firstUniqueCharacter = new FirstUniqueCharacter();
        firstUniqueCharacter.firstUniqChar(str);
    }
}
