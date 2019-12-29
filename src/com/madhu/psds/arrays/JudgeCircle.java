package com.madhu.psds.arrays;

public class JudgeCircle {
    public static void main(String[] args) {
        JudgeCircle judgeCircle = new JudgeCircle();
        System.out.print(judgeCircle.judgeCircle("UD"));
    }

    public boolean judgeCircle(String moves) {
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
