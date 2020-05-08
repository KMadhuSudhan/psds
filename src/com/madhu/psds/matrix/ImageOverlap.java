package com.madhu.psds.matrix;
//https://leetcode.com/problems/image-overlap/
//835. Image Overlap

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ImageOverlap {
    public static void main(String[] args) {
        ImageOverlap imageOverlap = new ImageOverlap();
        int[][] matrix = {
                {1,1,0},
                {0,1,0},
                {0,1,0}
        };
    }
    public int largestOverlap(int[][] A, int[][] B) {
        int max = 0;
        Map<Pair, Integer> count = new HashMap<>();
        for(int i = 0;i< A.length;i++) {
            for(int j = 0;j<A[0].length;j++) {
                if(A[i][j] == 1) {
                    for(int r = 0;r<B.length;r++) {
                        for(int c = 0;c<B[0].length;c++)  {
                            if(B[r][c] == 1) {
                                Pair p = new Pair(i-r, j-c);
                                count.put(p, count.getOrDefault(p, 0) +1);
                                max = Math.max(max, count.get(p));
                            }
                        }
                    }
                }
            }
        }
        return max;
    }

    class Pair {
        int r;
        int c;
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int hashCode() {
            return 31 * Objects.hashCode(r) + Objects.hashCode(c);
        }

        public boolean equals(Object obj) {
            Pair that = (Pair) obj;
            return this.r == that.r && this.c == that.c;
        }
    }
}
