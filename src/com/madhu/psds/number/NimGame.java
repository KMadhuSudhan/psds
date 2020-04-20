package com.madhu.psds.number;
//https://leetcode.com/problems/nim-game/
//292. Nim Game

public class NimGame {
    public boolean canWinNim(int n) {
        return (n % 4 != 0);
    }
}
