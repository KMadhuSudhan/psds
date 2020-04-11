package com.madhu.psds.linkedlist;

public class BackspaceString {
    public static void main(String[] args) {
        BackspaceString backspaceString = new BackspaceString();
        String S = "bxj##tw";
        String T = "bxo#j##tw";
        System.out.println(backspaceString.backspaceCompare(S, T));
    }

    public boolean backspaceCompare(String S, String T) {
        char[] sChars = S.toCharArray();
        char[] tChars = T.toCharArray();
        int sLength = sChars.length;
        int tLength = tChars.length;
        int sEnd = sLength - 1;
        int tEnd = tChars.length - 1;
        while (sEnd >= 0 || tEnd >= 0) {

            //tchars
            int tSpacesCount = 0;
            int backSpacesCount;
            while (tEnd >=0 && tChars[tEnd] == '#') {
                tSpacesCount++;
                tEnd--;
            }
            backSpacesCount = tSpacesCount;
            while (tEnd>=0  && backSpacesCount > 0) {
                if(tChars[tEnd] == '#') {
                    backSpacesCount++;
                    tEnd--;
                    continue;

                }
                tChars[tEnd] = '#';
                backSpacesCount--;
                tEnd--;
            }

            //schars
            int sBackSpacesCount = 0;
            while (sEnd >= 0 && sChars[sEnd] == '#') {
                sBackSpacesCount++;
                sEnd--;
            }
            backSpacesCount = sBackSpacesCount;
            while (sEnd>=0 && backSpacesCount > 0) {
                if(sChars[sEnd] == '#') {
                    backSpacesCount++;
                    sEnd--;
                    continue;
                }
                sChars[sEnd] = '#';
                backSpacesCount--;
                sEnd--;
            }
            if (sBackSpacesCount == 0) sEnd--;
            if (tSpacesCount == 0) tEnd--;
        }
        int sStart = 0, tStart = 0;
        while (sStart < sLength && tEnd < tLength) {
            while (sStart < sLength && sChars[sStart] == '#') {
                sStart++;
            }
            while (tStart < tLength && tChars[tStart] == '#') {
                tStart++;
            }
            if(sStart == sLength && tStart == tLength) return true;
            if (sStart < sLength && tStart < tLength && sChars[sStart] == tChars[tStart]) {
                sStart++;
                tStart++;
            } else {
                return false;
            }
        }
        return true;
    }
}
