package com.madhu.psds.strings;


public class Decompress {
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Decompress decompress = new Decompress();
        char[] chars = "2[a3[bc]]".toCharArray();
        decompress.strDecompress(chars,0,chars.length -1);
    }

    private void strDecompress(char[] chars,int start,int end) {
        while (start < end) {
            if(chars[start] == '[') {
                int index = findIndex(chars, start);
                if (index != -1) {
                    add(chars, start, index,chars[start-1]);
                    strDecompress(chars,start,end-1);
                }
            }
            start++;
        }
    }

    private int findIndex(char[] chars, int start) {
//        Stack<Character> stack = new Stack<>();
        int i = start;
        int open = 0;
        while (i < chars.length) {
            if (chars[i] == ']') {
                open--;
                if(open == 0) return i;
//                if (stack.peek() == ']') {
//                    return i;
//                }
            }
            if (chars[i] == '[') {
                open++;
//                stack.push('[');
            }
            i++;
        }
        return -1;
    }

    private void add(char[] chars,int start,int end,char n) {
        int rept = (int) (n -'0');
        StringBuilder stringBuilder = new StringBuilder();
        while (start<end) {
            stringBuilder.append(chars[start]);
            start++;
        }
        String str = stringBuilder.toString();
        int count = 0;
        while (count<rept) {
            sb.append(str);
            count++;
        }
    }
}
