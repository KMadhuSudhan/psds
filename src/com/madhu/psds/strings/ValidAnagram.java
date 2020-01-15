package com.madhu.psds.strings;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "a";
        String t = "b";
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram(s,t));
    }
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> sAnargamMap = new HashMap<>();
        Map<Character,Integer> tAnargamMap = new HashMap<>();
        int slength = s.length();
        int tlength = t.length();
        int i;
        for(i=0;i<slength;i++) {
            int count =  sAnargamMap.getOrDefault(s.charAt(i),0);
            sAnargamMap.put(s.charAt(i), count  +1);
        }
        for(i=0;i<tlength;i++) {
            int count =  tAnargamMap.getOrDefault(s.charAt(i),0);
            tAnargamMap.put(t.charAt(i), count +1);
        }
        for(Map.Entry<Character,Integer> entry: tAnargamMap.entrySet()) {
            if(entry.getValue() !=   sAnargamMap.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }
}
