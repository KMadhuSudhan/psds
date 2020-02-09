package com.madhu.psds.strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCombinations {
    public static void main(String[] args) {
        String str = "23";
        LetterCombinations letterCombinations = new LetterCombinations();
        letterCombinations.letterCombinations(str);
    }
    public List<String> letterCombinations(String digits) {
        String[] strArray = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        char[] chars = digits.toCharArray();
        List<String> result = new ArrayList<>();
        int digitsLength = digits.length();
        if(digitsLength == 0) return result;
        Queue<String> stringQueue = new LinkedList<>();
        stringQueue.add("");
        while (!stringQueue.isEmpty()) {
            String str = stringQueue.poll();
            if(str.length() == digitsLength) {
                result.add(str);
            } else {
                int index  = chars[str.length()] - '0';
                String pickedOne = strArray[index];
                for(int i=0;i<pickedOne.length();i++) {
                    stringQueue.add(str + pickedOne.charAt(i));
                }
            }
        }
        return result;
    }
}
