package com.madhu.psds.arrays;
//https://leetcode.com/problems/lemonade-change
//860. Lemonade Change

public class LemonadeChange {
    public static void main(String[] args) {
        LemonadeChange lemonadeChange = new LemonadeChange();
        int[] nums = {5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
        System.out.println(lemonadeChange.lemonadeChange(nums));
    }

    public boolean lemonadeChange(int[] bills) {
        int length = bills.length;
        int[] change = {0,0,0};
        if(length == 0) return true;
        for(int i=0;i<length;i++){
            switch (bills[i]) {
                case 5:
                    change[0]++;
                    break;
                case 10:
                    change[0]--;
                    change[1]++;
                    break;
                case 20:
                    if(change[1] == 0) {
                        change[0]--;
                        change[0]--;
                        change[0]--;
                    } else {
                        change[0]--;
                        change[1]--;
                    }
                    change[2]++;
                    break;
            }
            if(change[0] < 0 || change[1] < 0) return false;
        }
        return true;
    }
}
