package com.madhu.psds.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramDifference {
    public static void main(String[] args) {
        AnagramDifference anagramDifference = new AnagramDifference();

        List<String> a = new ArrayList();
        a.add("a");
        a.add("jk");
        a.add("abb");
        a.add("mn");
        a.add("abc");
        List<String> b = new ArrayList();
        a.add("bb");
        a.add("kj");
        a.add("bbc");
        a.add("op");
        a.add("def");
        anagramDifference.getMinimumDifference(a,b);
    }
    private List<Integer> getMinimumDifference(List<String> a, List<String> b) {
        int aLength = a.size();
        List<Integer> result = new ArrayList<>();
        int i,j,count;
        for(i=0;i<aLength;i++) {
            if(a.get(i).length()!=b.get(i).length()) {
                result.add(-1);
                continue;
            }
            count = 0;
            Map<Character,Integer> map = new HashMap<>();
            char[] aStrChars = a.get(i).toCharArray();
            int aStrLength = aStrChars.length;
            for(j=0;j<aStrLength;j++) {
                int charCount =  map.getOrDefault(aStrChars[j],0);
                map.put(aStrChars[j], charCount+1);
            }
            char[] bStrChars = b.get(i).toCharArray();
            int bStrLength = bStrChars.length;
            for(j=0;j<bStrLength;j++) {
                int charCount =  map.getOrDefault(aStrChars[j],0);
                map.put(aStrChars[j], charCount-1);
                if(map.get(aStrChars[j]) < 0) count++;
            }
            result.add(count);
        }
        return result;
    }
}
