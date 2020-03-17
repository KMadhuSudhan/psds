package com.madhu.psds.trees;

public class MagicDictionary {
    TrieNode root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String s : dict) {
            TrieNode cur = root;
            for (char ch : s.toCharArray()) {
                if (cur.children[ch - 'a'] == null) cur.children[ch - 'a'] = new TrieNode();
                cur = cur.children[ch - 'a'];
            }
            cur.isWord = true;
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return  search(root,word.toCharArray(),0,0);
    }
    public boolean search(TrieNode cur, char[] word, int index, int cnt) {
        if (cur == null || cnt > 1) {
            return false;
        }
        if (index == word.length) {
            return cur.isWord && cnt == 1;
        }

        for (int i = 0; i < 26; ++i) {
            if (search(cur.children[i], word, index + 1, (word[index] - 'a' != i) ? cnt + 1 : cnt)) {
                return true;
            }
        }
        return false;
    }
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }
}
