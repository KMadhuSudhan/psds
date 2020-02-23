package com.madhu.psds.strings;

import java.util.*;
import java.util.stream.IntStream;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        char[] sCharArr = s.toCharArray();
        int length = sCharArr.length;
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < length; i++) {
            int count = map.getOrDefault(sCharArr[i], 0);
            map.put(sCharArr[i], count + 1);
        }
        String str = "";
        List<Map.Entry<Character, Integer>> temp = sortByFreq(map);
        for (Map.Entry<Character, Integer> entry : temp) {
            int count = entry.getValue();
            while (count-- > 0) {
                str+= entry.getKey();
            }
        }
        return str;
    }

    List<Map.Entry<Character, Integer>> sortByFreq(Map<Character, Integer> map) {
        List<Map.Entry<Character, Integer>> list = new LinkedList<>(map.entrySet());
        Comparator<Map.Entry<Character, Integer>> comparator = new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };
        Collections.sort(list, comparator);
        return list;
    }

    //java 8
    public String frequencySort8(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        StringBuilder sb = new StringBuilder();

        map.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .forEach(x ->
                        IntStream.range(0, (int) x.getValue()).forEach(i -> sb.append(x.getKey())));
        return sb.toString();
    }
    public static void main(String[] args) {
        SortCharactersByFrequency sortCharactersByFrequency = new SortCharactersByFrequency();
        String str = "eetree";
        System.out.println(sortCharactersByFrequency.frequencySort(str));
    }
}
