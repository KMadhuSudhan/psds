package com.madhu.psds.arrays;

public class BulbSwitcher {
    public static void main(String[] args) {
        BulbSwitcher bulbSwitcher = new BulbSwitcher();
        bulbSwitcher.bulbSwitch(3);
    }
    public int bulbSwitch(int n) {
        int count =0;
        for(int i=1;i*i<=n;i++) {
            count++;
        }
        return count;
    }
}
