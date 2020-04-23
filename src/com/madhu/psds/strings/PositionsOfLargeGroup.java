package com.madhu.psds.strings;
//https://leetcode.com/problems/positions-of-large-groups
//830. Positions of Large Groups

import java.util.ArrayList;
import java.util.List;

public class PositionsOfLargeGroup {
    public static void main(String[] args) {
        PositionsOfLargeGroup positionsOfLargeGroup = new PositionsOfLargeGroup();
        String str = "abcdddeeeeaabbbcd";
        positionsOfLargeGroup.largeGroupPositions(str);
    }
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();
        char[] chars = S.toCharArray();
        int length = chars.length;
        int i=0;
        while (i<length) {
            int j=i+1;
            while ( j < length && chars[j] == chars[i]) j++;
            if(i==j-1) {
                i++;
                continue;
            }
            if((j - i) < 3) {
                i = j-1;
                continue;
            }
            List<Integer> group = new ArrayList<>();
            group.add(i);
            group.add(j-1);
            result.add(group);
            i = j-1;
        }
        return result;
    }
}
