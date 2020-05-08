package com.madhu.psds.matrix;
//https://leetcode.com/problems/random-flip-matrix/
//519. Random Flip Matrix
//https://leetcode.com/problems/random-flip-matrix/submissions/
//519. Random Flip Matrix

import java.util.HashSet;
import java.util.Random;

public class RandomFlipMatrix {

    private int R, C;
    private Random random;
    private HashSet<Integer> used;

    public RandomFlipMatrix(int n_rows, int n_cols) {
        this.R = n_rows;
        this.C = n_cols;
        this.random = new Random();
        this.used = new HashSet();
    }

    public int[] flip() {
        while(true) {
            int x = this.random.nextInt(R);
            int y = this.random.nextInt(C);
            int code = hashCode(x, y);
            if(this.used.add(code)) {
                return new int[] {x,y};
            }
        }
    }

    public void reset() {
        this.used.clear();
    }

    private int hashCode(int x, int y){
        // Szudzik's Pairing Function
        if(x >= y)
            return x*x + x + y;
        else
            return x + y*y;
    }
}
