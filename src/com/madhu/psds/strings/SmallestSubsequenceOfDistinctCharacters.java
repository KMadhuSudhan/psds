package com.madhu.psds.strings;


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SmallestSubsequenceOfDistinctCharacters {
    public static void main(String[] args) {
        SmallestSubsequenceOfDistinctCharacters smallestSubsequenceOfDistinctCharacters = new SmallestSubsequenceOfDistinctCharacters();
        smallestSubsequenceOfDistinctCharacters.smallestSubsequence("cdadabcc");
    }

    public String smallestSubsequence(String text) {
        char[] textChars = text.toCharArray();
        int length = textChars.length;
        int[] distinctChars = new int[26];
        for (int i=0;i<length;i++) {
            distinctChars[textChars[i] -'a'] = i;
        }
        Stack<Character> characterStack = new Stack<>();
        Set<Character> characters = new HashSet<>();
        for (int i=0;i<length;i++) {
            if(!characterStack.contains(textChars[i])) {
                while(!characters.isEmpty() && characterStack.peek() > textChars[i] && distinctChars[textChars[i] - 'a'] > i) {
                    characterStack.pop();
                    characters.remove(textChars[i]);
                }
                characterStack.push(textChars[i]);
                characters.add(textChars[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<characterStack.size();i++) {
            sb.append(characterStack.pop());
        }
       return sb.reverse().toString();
    }
}
