package com.madhu.psds.strings;
//68. Text Justification
//https://leetcode.com/problems/text-justification/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        TextJustification textJustification = new TextJustification();
        List<String> stringList =  textJustification.fullJustify(words,16);
        textJustification.print(stringList);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();

        List<String> row = new ArrayList<>();
        int rowWidth = 0;
        for (int i = 0; i < words.length; i++) {
            int maxWordLength = maxWidth - rowWidth - row.size();
            if (words[i].length() <= maxWordLength) {
                row.add(words[i]);
                rowWidth += words[i].length();
                continue;
            }

            int totalSpaces = maxWidth - rowWidth;
            StringBuilder sb = new StringBuilder();
            if (row.size() == 1) {
                sb.append(row.get(0));
                sb.append(Collections.nCopies(totalSpaces," "));
            } else {
                int minSpaces = totalSpaces / (row.size() - 1);
                int numOfMoreSpaces = totalSpaces - minSpaces * (row.size() - 1);
                for (int j = 0; j < row.size(); j++) {
                    sb.append(row.get(j));
                    if (j < row.size() - 1) {
                        if (j < numOfMoreSpaces) {
                            sb.append(Collections.nCopies(minSpaces+1," "));
                        } else {
                            sb.append(Collections.nCopies(minSpaces," "));
                        }
                    }
                }
            }
            res.add(sb.toString());
            row = new ArrayList<>();
            row.add(words[i]);
            rowWidth = words[i].length();
        }

        // Handle last line
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < row.size(); j++) {
            sb.append(row.get(j));
            if (j != row.size() - 1) {
                sb.append(" ");
            }
        }
        sb.append(Collections.nCopies(maxWidth - sb.length()," "));
        res.add(sb.toString());
        return res;
    }

    void print(List<String> words) {
        for(String word: words) {
            System.out.println(word.length());
            System.out.println(word);
        }
    }
}