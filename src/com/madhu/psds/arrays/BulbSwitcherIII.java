package com.madhu.psds.arrays;
//https://leetcode.com/problems/bulb-switcher-iii/submissions/
//1375. Bulb Switcher III

public class BulbSwitcherIII {
    public static void main(String[] args ) {
        BulbSwitcherIII bulbSwitcherIII = new BulbSwitcherIII();
        int[] bulbs = {1,2,3,4,5,6,18,8,30,10,11,12,13,14,17,16,15,7,19,20,41,22,23,24,33,26,27,25,29,9,31,32,28,34,35,36,37,38,39,40,21,42};
        System.out.println(bulbSwitcherIII.numTimesAllBlue(bulbs));
    }
    public int numTimesAllBlue(int[] light) {
        int count =0,length=light.length;
        int max = Integer.MIN_VALUE;
        int on =0;
        for (int i=0;i<length;i++) {
            max = Math.max(max, light[i]);
            on++;
            if(on==max) count++;
        }
        return count;
    }
}
