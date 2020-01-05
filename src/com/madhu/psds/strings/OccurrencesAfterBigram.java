package com.madhu.psds.strings;

import java.util.ArrayList;
import java.util.List;

public class OccurrencesAfterBigram {
    public static void main(String[] args) {
        String text = "alice is a good girl she is a good student";
        String first = "a";
        String second = "good";
        OccurrencesAfterBigram occurrencesAfterBigram = new OccurrencesAfterBigram();
        occurrencesAfterBigram.findOcurrences(text, first, second);
    }

    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        int length = words.length;
        int i;
        List<String> thirdWords = new ArrayList<>();
        for (i = 0; i < length; i++) {
            if (words[i].equals(first) && words[i + 1].equals(second)) {
                thirdWords.add(words[i + 2]);
            }
        }
        String[] thirdWordsArray =  new String[thirdWords.size()];
        for(i=0;i<thirdWords.size();i++ ) {
            thirdWordsArray[i] = thirdWords.get(i);
        }
        return thirdWordsArray;
    }
}
