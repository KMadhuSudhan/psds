package com.madhu.psds.strings;

public class DetectCapital {
    public static void main(String[] args) {
        String word = "FFFFFFFFFFFFFFFFFFFFf";
        DetectCapital detectCapital = new DetectCapital();
        System.out.println(detectCapital.detectCapitalUse(word));
    }

    public boolean detectCapitalUse(String word) {
        char[] wordChars = word.toCharArray();
        int length =  wordChars.length;
        if(length<2) return true;
        if(wordChars[0] >= 65 && wordChars[0]<= 90 && wordChars[1] >= 65 && wordChars[1]<= 90) {
            for (int i=2;i<length;i++) {
                if(wordChars[i] >= 65 && wordChars[i]<= 90) continue;
                return false;
            }
        }  else {
            for (int i=0;i<length;i++) {
                if(wordChars[i] >= 97 && wordChars[i]<= 122) continue;
                return false;
            }
        }
        return true;
    }
}
