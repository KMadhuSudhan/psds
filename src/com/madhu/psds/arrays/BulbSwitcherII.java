package com.madhu.psds.arrays;

public class BulbSwitcherII {
    public static void main(String[] args) {
        BulbSwitcherII bulbSwitcherII = new BulbSwitcherII();
        bulbSwitcherII.flipLights(2,1);
    }
    public int flipLights(int n, int m) {
        n = Math.min(n, 3);
        if (m == 0) return 1;
        if (m == 1) return n == 1 ? 2 : n == 2 ? 3 : 4;
        if (m == 2) return n == 1 ? 2 : n == 2 ? 4 : 7;
        return n == 1 ? 2 : n == 2 ? 4 : 8;
    }
}
