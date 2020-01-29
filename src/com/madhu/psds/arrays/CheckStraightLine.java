package com.madhu.psds.arrays;

public class CheckStraightLine {
    public static void main(String[] args) {
        int[][] coordinates = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        CheckStraightLine checkStraightLine = new CheckStraightLine();
        checkStraightLine.checkStraightLine(coordinates);
    }
    public boolean checkStraightLine(int[][] coords) {
        //Condition of collinearity of three points
        // x1 (y2  - y3) + x2 (y3 - y1) + x3 (y1 - y2) = 0
        for(int i=2;i<coords.length;i++){
            int total = coords[0][0]*(coords[1][1] - coords[i][1]) + coords[1][0]*(coords[i][1] - coords[0][1]) + coords[i][0]*(coords[0][1] - coords[1][1]);
            if(total!=0)
                return false;
        }
        return true;
    }
}
