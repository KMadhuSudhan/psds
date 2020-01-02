package com.madhu.psds.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonCharacters {
    public static void main(String[] args) {
        String[] input = new String[]{"bcaddcdd","cbcdccdd","ddccbdda","dacbbdad","dababdcb","bccbdaad","dbccbabd","accdddda"};
        CommonCharacters commonCharacters = new CommonCharacters();
        commonCharacters.commonChars(input);
    }

    public List<String> commonChars(String[] A) {
        int inputLength = A.length;
        List<String> result = new ArrayList<>();
        int i, j;
        Map<String,Map<Character,Integer>> countMap = new HashMap();

        for(i = 0; i < inputLength; i++) {
            String str = A[i];
            char[] strChars = A[i].toCharArray();
            int strCharsLength = strChars.length;
            Map<Character,Integer> strCharsMap = new HashMap();
            for(j=0;j<strCharsLength;j++) {
                int count = strCharsMap.getOrDefault(strChars[j],0);
                strCharsMap.put(strChars[j],count+1);
            }
            countMap.put(str,strCharsMap);
        }
        Map<Character,Integer> firstStrMap = countMap.get(A[0]);
        for(Map.Entry<Character,Integer> entry: firstStrMap.entrySet()) {
            int minRepeated = entry.getValue();
            for (i = 1; i < inputLength; i++) {
                Map<Character,Integer> strMap = countMap.get(A[i]);
                if(strMap.get(entry.getKey())!=null) {
                    minRepeated =  Math.min(minRepeated, strMap.get(entry.getKey()));
                } else {
                    minRepeated = 0;
                    break;
                }
            }
            for(j=0;j<minRepeated;j++) {
                result.add(String.valueOf(entry.getKey()));
            }
        }
        return result;
    }
}