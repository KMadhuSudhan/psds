package com.madhu.psds.matrix;
//https://leetcode.com/problems/word-search-ii
//212. Word Search II

import sun.dc.pr.PRError;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
    private  Trie root;
    public static void main(String[] args) {
        WordSearchII wordSearchII = new WordSearchII();
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> wordsWithTrie  = wordSearchII.findWordsWithTrie(board, words);
        System.out.println(wordsWithTrie);
    }

    //without trie
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        int rows = board.length;
        int cols = board[0].length;
        for (String word : words) {
            char[] charArray = word.toCharArray();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] == charArray[0] && dfs(board, charArray, 0, i, j, rows, cols)) {
                        result.add(word);
                    }
                }
            }
        }
        return result;
    }

    private boolean dfs(char[][] board, char[] word, int index, int row, int col, int rows, int cols) {
        if (index >= word.length) return true;
        if (row < 0 || row >= rows || col < 0 || col >= cols) return false;
        if (board[row][col] != word[index]) return false;
        char temp = board[row][col];
        board[row][col] = '_';
        boolean match = dfs(board, word, index + 1, row - 1, col, rows, cols);
        match = match || dfs(board, word, index + 1, row + 1, col, rows, cols);
        match = match || dfs(board, word, index + 1, row, col - 1, rows, cols);
        match = match || dfs(board, word, index + 1, row, col + 1, rows, cols);
        board[row][col] = temp;
        return match;
    }

    //with trie
    class TrieNode {
        TrieNode[] childrens;
        boolean isEndOfWord;

        TrieNode() {
            childrens = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    class OldTrie {
        TrieNode root;
        TrieNode temp;

        public OldTrie() {
            root = new TrieNode();
        }

        void insert(String word) {
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

        public boolean isPresent(String word) {
            temp = root;
            for (char ch : word.toCharArray()) {
                if (temp.childrens[ch - 'a'] == null) return false;
                temp = temp.childrens[ch - 'a'];
            }
            return temp.isEndOfWord;
        }

        public boolean[] isPrefix(String word) {
            temp = root;
            for (char ch : word.toCharArray()) {
                if (temp.childrens[ch - 'a'] == null) return new boolean[]{false,false};
                temp = temp.childrens[ch - 'a'];
            }
            return new boolean[]{true,temp.isEndOfWord};
        }

    }

    public List<String> findWordsWithTrie(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        int rows = board.length;
        int cols = board[0].length;
        OldTrie trie = new OldTrie();
        for (String word : words) {
            trie.insert(word);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                  boolean[][] visited = new boolean[rows][cols];
                if (trie.root.childrens[board[i][j] - 'a'] != null) {
                    dfs(board, result, visited,trie, i, j, rows, cols, String.valueOf(board[i][j]));
                }
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(char[][] board,  Set<String> result, boolean[][] visited,OldTrie trie, int row, int col, int rows, int cols, String word) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col]) return;
        boolean[] searchResult = trie.isPrefix(word);
        if(!searchResult[0]) return;
        visited[row][col] = true;
        if(searchResult[1]) result.add(word.toString());
        for (int[] neigh : neighbors(board, row, col)) {
            if (!visited[neigh[0]][neigh[1]]) {
                dfs(board, result,visited,trie, neigh[0], neigh[1], rows, cols, word +  String.valueOf(board[neigh[0]][neigh[1]]));
            }
        }
        visited[row][col] = false;
    }

    public List<int[]> neighbors (char[][] board, int row, int col) {
        int rows = board.length; int cols = board[0].length;
        List<int[]> list = new ArrayList<>();
        if (row-1 >= 0) list.add(new int[]{row-1, col});
        if (col-1 >= 0) list.add(new int[]{row, col-1});
        if (col+1 < cols) list.add(new int[]{row, col+1});
        if (row+1 < rows) list.add(new int[]{row+1, col});
        return list;
    }

    //private Trie root;
    public List<String> findWordsPerformance(char[][] board, String[] words) {
        root = new Trie();
        build(words);
        List<String> res = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                find(res, i, j, board, root);
            }
        }
        return res;
    }

    private void find(List<String> res, int i, int j, char[][] board, Trie node){
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == '#') return;
        Trie next = node.next[board[i][j]-'a'];
        if(next == null) return;
        if(next.word != null) {
            res.add(next.word);
            next.word = null;
        }
        char c = board[i][j];
        board[i][j] = '#';
        find(res, i+1, j, board, next);
        find(res, i-1, j, board, next);
        find(res, i, j+1, board, next);
        find(res, i, j-1, board, next);
        board[i][j] = c;
    }

    private void build (String[] words) {
        for(String w: words) {
            Trie node = root;
            for(int i=0; i<w.length(); i++){
                if(node.next[w.charAt(i)-'a'] == null) node.next[w.charAt(i)-'a'] = new Trie();
                node = node.next[w.charAt(i)-'a'];
            }
            node.word = w;
        }
    }

    private class Trie {
        private Trie[] next;
        private String word;
        public Trie() {
            next = new Trie[26];
        }
    }
}
