package com.madhu.psds.matrix;
//https://leetcode.com/problems/word-search/
//79. Word Search

public class WordSearch {
    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };
        wordSearch.findWords(board, "ABCCED");
    }

    public boolean findWords(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        char[] charArray = word.toCharArray();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == charArray[0] && dfs(board, charArray, 0, i, j, rows, cols)) {
                    return true;
                }
            }
        }
        return false;
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
}
