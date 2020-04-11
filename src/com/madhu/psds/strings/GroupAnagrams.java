package com.madhu.psds.strings;
//https://leetcode.com/problems/group-anagrams/
//49. Group Anagrams

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        groupAnagrams.groupAnagrams(input);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<Long,Integer> map = new HashMap<>();
        int length = strs.length;

        int count = 0;
        for(int i=0;i<length;i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            long code = 0;
            for (int c=0;c<chars.length;c++) {
                code = code*31 + chars[c];
            }
            if(map.containsKey(code)) {
                result.get(map.get(code)).add(strs[i]);
            } else {
                List<String> stringList = new ArrayList<>();
                stringList.add(strs[i]);
                map.put(code,count);
                count++;
                result.add(stringList);
            }
        }
        return result;
    }
}
