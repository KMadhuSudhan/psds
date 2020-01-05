package com.madhu.psds.arrays;

public class PlayWithChips {
    public static void main(String[] args) {
        PlayWithChips playwithChips = new PlayWithChips();
        int[] chips = new int[]{1, 2, 3};
        System.out.println(playwithChips.minCostToMoveChips(chips));
    }

    public int minCostToMoveChips(int[] chips) {
        int evens = 0;
        int odds = 0;

        for (int chip : chips) {
            if (chip % 2 == 0) evens++;
            if (chip % 2 == 1) odds++;
        }

        return Math.min(evens, odds);
    }
}