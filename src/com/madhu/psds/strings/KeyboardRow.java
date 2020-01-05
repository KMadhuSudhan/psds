package com.madhu.psds.strings;

import java.util.ArrayList;
import java.util.HashMap;

public class KeyboardRow {
    public static void main() {
        String[] words = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.findWords(words);
    }

    public String[] findWords(String[] words) {
        HashMap<Character, Integer> hm = new HashMap<>();
        //Add the rows of alphabets in the keyboard with the corresponding line numbers
        char[] line1 = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        char[] line2 = {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        char[] line3 = {'z', 'x', 'c', 'v', 'b', 'n', 'm'};
        for (int i = 0; i < line1.length; i++) {
            hm.put(line1[i], 1);
        }
        for (int i = 0; i < line2.length; i++) {
            hm.put(line2[i], 2);
        }
        for (int i = 0; i < line3.length; i++) {
            hm.put(line3[i], 3);
        }
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            String s = words[i].toLowerCase();
            char[] c = s.toCharArray();
            boolean canType = true;
            for (int j = 0; j < c.length - 1; j++) {
                //if any two alphabets are in two different lines, make the corresponding word to empty string
                if (hm.get(c[j]) != hm.get(c[j + 1])) {
                    canType = false;
                    break;
                }
            }
            if (canType) {
                res.add(words[i]);
            }
        }
        //add those words which are not set to empty string and return it as ans.

        String[] arr = new String[res.size()];
        return res.toArray(arr);
    }
}
