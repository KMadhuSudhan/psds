package com.madhu.psds.trees;
//https://leetcode.com/problems/implement-trie-prefix-tree/
//208. Implement Trie (Prefix Tree)

public class Trie {
    TrieNode root;
    TrieNode temp;
    class TrieNode {
        TrieNode[] childrens;
        boolean isEndOfWord;

        TrieNode() {
            childrens = new TrieNode[26];
            isEndOfWord = false;
        }
    }
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        temp = root;
        char[] chars = word.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            char character = (char) (chars[i] - 'a');
            if (temp.childrens[character] == null) {
                temp.childrens[character] = new TrieNode();
            }
            temp = temp.childrens[character];
        }
        temp.isEndOfWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        temp = root;
        for (char ch : word.toCharArray()) {
            if (temp.childrens[ch - 'a'] == null) return false;
            temp = temp.childrens[ch - 'a'];
        }
        return temp.isEndOfWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        temp = root;
        for (char ch : prefix.toCharArray()) {
            if (temp.childrens[ch - 'a'] == null) return false;
            temp = temp.childrens[ch - 'a'];
        }
        return true;
    }

    private boolean searchHelper(String word, int wordIndex, TrieNode parent) {
        if (wordIndex == word.length()) {
            return parent.isEndOfWord;
        }

        char c = word.charAt(wordIndex);
        if (c == '.') {
            //DFS for any potential solution!
            for (TrieNode child : parent.childrens) {
                if (searchHelper(word, wordIndex+1, child)) {
                    return true;
                }
            }
        } else if (parent.childrens[c -'a']!=null) {
            TrieNode child = parent.childrens[c - 'a'];
            return searchHelper(word, wordIndex+1, child);
        }
        return false;
    }

    public boolean endWith(String prefix) {
      return searchHelper(prefix,0,root);
    }
}
