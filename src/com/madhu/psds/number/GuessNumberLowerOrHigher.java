package com.madhu.psds.number;
//https://leetcode.com/problems/guess-number-higher-or-lower/
//374. Guess Number Higher or Lower

public class GuessNumberLowerOrHigher {
    public static void main(String[] args) {
        GuessNumberLowerOrHigher guessNumberLowerOrHigher = new GuessNumberLowerOrHigher();
        guessNumberLowerOrHigher.guess(10);
    }

    public int guess(int n) {
        return 0;
    }

    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0)
                return mid;
            else if (res < 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
