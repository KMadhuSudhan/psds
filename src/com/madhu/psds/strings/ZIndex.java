package com.madhu.psds.strings;

import java.util.ArrayList;
import java.util.List;

public class ZIndex {
    public static void main(String[] args) {
        String str = "baabaa";
        String pattern = "aab";

    }

    public List<Integer> findPattern(String str, String pttern) {
        String text = str + "$" + pttern;
        int[] z = calculateZ(text);
        int zLength = z.length;
        int patternLength = pttern.length();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < zLength; i++) {
            if (z[i] == patternLength) {
                result.add(i - patternLength - 1);
            }
        }
        return result;
    }

    public int[] calculateZ(String text) {
        int length = text.length();
        char[] chars = text.toCharArray();
        int[] z = new int[length];
        int left = 0;
        int right = 0;
        for (int k = 1; k < length; k++) {
            if (k > right) {
                left = right = k;
                while (right < length && chars[right] == chars[right - left])
                    right++;
                z[k] = right - left;
                right--;
            } else {
                int k1 = k - left;
                if (z[k1] < right - k + 1) {
                    z[k] = z[k1];
                } else {
                    left = k;
                    while (right < length && chars[right] == chars[right - left])
                        right++;
                    z[k] = right - left;
                    right--;
                }
            }
        }
        return z;
    }

}
