package com.madhu.psds.strings;

import java.util.HashMap;

public class GoatLatin {
    public static void main(String[] args) {
        GoatLatin goatLatin = new GoatLatin();
        String s = "I speak Goat Latin";
        goatLatin.toGoatLatin(s);
    }

    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        HashMap<Character, Character> vowelMap = getVowelMap();
        int count = 1;
        int length = words.length;
        StringBuilder rs = new StringBuilder();
        for (String word : words) {
            char firstChar = word.charAt(0);
            if (vowelMap.containsKey(firstChar)) {
                word = word + "ma";
            } else {
                word = word + word.charAt(0);
                int wordLength = word.length();
                word = word.substring(1,wordLength);
                word = word + "ma";
            }
            for (int i = 0; i < count; i++) {
                word = word + "a";
            }
            count++;
            rs.append(word);
            if(count <= length) rs.append(" ");
        }
        return rs.toString();
    }

    private HashMap<Character, Character> getVowelMap() {
        HashMap<Character, Character> vowels = new HashMap();
        vowels.put('a', 'a');
        vowels.put('e', 'e');
        vowels.put('i', 'i');
        vowels.put('o', 'o');
        vowels.put('u', 'u');
        vowels.put('A', 'A');
        vowels.put('E', 'E');
        vowels.put('I', 'I');
        vowels.put('O', 'O');
        vowels.put('U', 'U');
        return vowels;
    }
}
