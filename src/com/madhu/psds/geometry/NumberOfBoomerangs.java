package com.madhu.psds.geometry;
//https://leetcode.com/problems/number-of-boomerangs/
//447. Number of Boomerangs

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {

    public static void main(String[] args) {
        NumberOfBoomerangs numberOfBoomerangs = new NumberOfBoomerangs();
    }

    public int numberOfBoomerangs(int[][] ps) {
        int res = 0;
        for (int i = 0; i < ps.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();   //for each starting point i;
            for (int j = 0; j < ps.length; j++) {
                int a = ps[i][0] - ps[j][0], b = ps[i][1] - ps[j][1], dist = a * a + b * b, cnt = map.getOrDefault(dist, 0);
                res += cnt * 2;  // j and k are switchable
                map.put(dist, cnt + 1);
            }
        }
        return res;
    }
}
