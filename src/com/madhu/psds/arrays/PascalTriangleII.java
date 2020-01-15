package com.madhu.psds.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public static void main(String[] args) {
        PascalTriangleII pascalTriangleII = new PascalTriangleII();
        System.out.println(pascalTriangleII.getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> pascal = new ArrayList<>();
        List<Integer> line = new ArrayList<>();
        for (int i =0;i<33;i++) {
            line = new ArrayList<>();
            for (int j=0;j<=i;j++) {
                if(j == 0 || j == i) {
                    line.add(1);
                } else {
                    line.add(pascal.get(i-1).get(j-1) + pascal.get(i-1).get(j));
                }
            }
            pascal.add(line);
            if(i==rowIndex) {
                return line;
            }
        }
        return line;
    }
}
