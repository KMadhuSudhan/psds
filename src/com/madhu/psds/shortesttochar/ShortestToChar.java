package com.madhu.psds.shortesttochar;

public class ShortestToChar {

    public static void main(String[] s) {
        int[] distanceArray = shortestToChar("loveleetcode",'b');
        System.out.println();
        for(int i=0;i<distanceArray.length;i++) {
            System.out.print(distanceArray[i] + " ");
        }
    }
    private static int[] shortestToChar(String S, char C) {
        char[] s = S.toCharArray();
        int l = s.length;
        int i = 0;
        int[] charLengthArray = new int[l];
        int firstPtr = 0;
        int secondPtr = 0;
        int thirdPtr = 0;
        while(i < l && firstPtr < l) {
            while(firstPtr < l && s[firstPtr]!=C) {
                firstPtr++;
            }
            if(secondPtr == 0) {
                secondPtr = firstPtr;
            }
            if(firstPtr == l) {
                firstPtr = secondPtr;
            }
            if(firstPtr < l) {
                thirdPtr = firstPtr;
                thirdPtr++;
                while (thirdPtr < l && s[thirdPtr] != C) {
                    thirdPtr++;
                }
                if(thirdPtr < l && s[thirdPtr] == C) {
                    thirdPtr++;
                } else if (thirdPtr == l) {
                    thirdPtr = firstPtr;
                }
            }

            System.out.println("secondPtr" + secondPtr);
            System.out.println("thirdPtr" + thirdPtr);

            while(i<l && s[i]!=C || ( i== 0  && s[i] == C)) {
                int ldistance = Math.min(Math.abs(firstPtr - i), Math.abs(secondPtr - i));
                int rdistance = Math.min(Math.abs(secondPtr - i), Math.abs(thirdPtr - i));

                charLengthArray[i] = Math.min(ldistance,rdistance);
                i++;
            }
            secondPtr = firstPtr;
            if(i<l && charLengthArray[i] == C) {
                charLengthArray[i] = 0;
            }
            if(i == l -1) break;
            firstPtr++;
            i++;
        }
        return charLengthArray;
    }
}