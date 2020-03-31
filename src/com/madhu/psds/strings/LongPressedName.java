package com.madhu.psds.strings;
//https://leetcode.com/problems/long-pressed-name/
//925. Long Pressed Name

public class LongPressedName {
    public static void main(String[] args) {
        String name = "alex";
        String typed = "aaleex";
        LongPressedName longPressedName = new LongPressedName();
        longPressedName.isLongPressedName(name, typed);
    }

    public boolean isLongPressedName(String name, String typed) {
        char[] nameChars = name.toCharArray();
        char[] typedChars = typed.toCharArray();
        int nameLength = nameChars.length;
        int typedLength = typedChars.length;
        int nameStart = 0;
        int typedStart = 0;
        while (nameStart < nameLength && typedStart < typedLength) {
            if(nameChars[nameStart] == typedChars[typedStart]) {
                nameStart++;
                typedStart++;
            } else if(nameStart > 0 && nameChars[nameStart-1] == typedChars[typedStart]) {
                typedStart++;
            } else {
                return false;
            }
        }
        return nameStart!=nameLength ? false : true;
    }
}
