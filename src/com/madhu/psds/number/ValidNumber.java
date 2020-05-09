package com.madhu.psds.number;
//https://leetcode.com/problems/valid-number/
//65. Valid Number
//https://leetcode.com/problems/valid-number/discuss/585547/simple-java-code-with-FSM-graph

public class ValidNumber {

    public boolean isNumber(String s) {
        int[][] state = new int[][]{
                // the meaning of state[i][j] is:
                //  assuming current state is `state_start`
                //  if the next character is `0-9`, then the j will be 0
                //  then we will go to state[0][0]=state_2

                // "0-9", ".", "+/-", "e/E"
                new int[]{2, 3, 1, -1},   // state_start
                new int[]{2, 3, -1, -1},  // state_1
                new int[]{2, 4, -1, 5},   // state_2
                new int[]{4, -1, -1, -1}, // state_3
                new int[]{4, -1, -1, 5},  // state_4
                new int[]{7, -1, 6, -1},  // state_5
                new int[]{7, -1, -1, -1}, // state_6
                new int[]{7, -1, -1, -1}, // state_7
        };
        // remove the leading and trailing space
        char[] ca = s.trim().toCharArray();
        int curState = 0;
        for (int i = 0; i < ca.length; i++) {
            int input;
            if (ca[i] >= '0' && ca[i] <= '9') input = 0;
            else if (ca[i] == '.') input = 1;
            else if (ca[i] == '+' || ca[i] == '-') input = 2;
            else if (ca[i] == 'e' || ca[i] == 'E') input = 3;
            else return false;
            curState = state[curState][input];
            if (curState == -1) break;
        }
        if (curState == 2 || curState == 4 || curState == 7)
            return true;
        return false;
    }

    public boolean isNumberWith35(String s) {
        int[][] machine = {
                //{-, D, e, .},
                {4, 1, 8, 5},
                {8, 1, 6, 2},
                {8, 2, 6, 8},
                {8, 3, 8, 8},
                {8, 1, 8, 5},
                {8, 2, 8, 8},
                {7, 3, 8, 8},
                {8, 3, 8, 8},
                {8, 8, 8, 8}
        };

        if (s != null) {
            char [] c = s.trim().toCharArray();
            //we are starting with state 0
            int state = 0;

            for (int i=0; i<c.length; i++) {
                int input = getInput(c[i]);
                if (input < 0) {
                    return false;
                }
                state = machine[state][input];
                if (state == 8) return false;
            }
            if (state == 1 || state ==2 || state ==3) return true;
        }
        return false;
    }

    private int getInput(char c) {
        if (c == '+' || c == '-') return 0;
        if (Character.isDigit(c)) return 1;
        if (c == 'e') return 2;
        if (c == '.') return 3;
        return -1;
    }
}
