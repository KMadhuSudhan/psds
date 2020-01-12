package com.madhu.psds.bits;

public class LongestDistanceBetweenBits {
    public static void main(String[] args) {
        LongestDistanceBetweenBits longestDistanceBetweenBits = new LongestDistanceBetweenBits();
        System.out.println(longestDistanceBetweenBits.binaryGap(6));
    }

    public int binaryGap(int n) {
        String binaryNumber = "";
        int distance = 0;
        int maxDistance = 0;
        boolean firstOneFound = false;
        boolean secondOneFound = false;
        while (n > 0) {
            int r = n % 2;
            if (r == 1) {
                if (firstOneFound == true) {
                    secondOneFound = true;
                }
                firstOneFound = true;
                maxDistance = Math.max(distance, maxDistance);
                distance = 0;
            } else {
               if(firstOneFound) distance++;
            }
            binaryNumber = r + binaryNumber;
            n = n / 2;
        }
        System.out.println("number " + binaryNumber);
        if (firstOneFound && secondOneFound) {
            maxDistance = maxDistance + 1;
            return maxDistance;
        }
        return 0;
    }
}
