package com.madhu.psds.trees;
//https://leetcode.com/problems/add-and-search-word-data-structure-design/
//211. Add and Search Word - Data structure design

public class AddAndSearchWord {
    TrieNode root;
    TrieNode temp;
    class TrieNode {
        TrieNode[] childrens;
        boolean isEndOfWord;

        TrieNode() {
            childrens = new TrieNode[256];
            isEndOfWord = false;
        }
    }

    /** Initialize your data structure here. */
    public AddAndSearchWord() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        temp = root;
        char[] chars = word.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            if(chars[i] == '.') continue;
            char character = (char) (chars[i] - 'a');
            if (temp.childrens[character] == null) {
                temp.childrens[character] = new TrieNode();
            }
            temp = temp.childrens[character];
        }
        temp.isEndOfWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchHelper(word,0,root);
    }

    private boolean searchHelper(String word, int wordIndex, TrieNode parent) {

        if (wordIndex == word.length()) {
            return parent.isEndOfWord;
        }

        char c = word.charAt(wordIndex);
        if (c == '.') {
            //DFS for any potential solution!
            for (TrieNode child : parent.childrens) {
                if (child!=null && searchHelper(word, wordIndex+1, child)) {
                    return true;
                }
            }
        } else if (parent.childrens[c -'a']!=null) {
            TrieNode child = parent.childrens[c - 'a'];
            return searchHelper(word, wordIndex+1, child);
        }
        return false;
    }
}
