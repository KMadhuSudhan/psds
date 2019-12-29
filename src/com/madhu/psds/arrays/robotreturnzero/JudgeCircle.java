package com.madhu.psds.arrays.robotreturnzero;

public class JudgeCircle {
    final static int COUNT = 10;


    public static void main(String[] args) {
        System.out.print(judgeCircle("UD"));
    }

    private static boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char move : moves.toCharArray()) {
            if (move == 'U') y++;
            else if (move == 'D') y--;
            else if (move == 'L') x--;
            else if (move == 'R') x++;
        }
        return x == 0 && y == 0;
    }
}
