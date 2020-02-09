package com.madhu.psds.number;

public class PerfectNumber {
    public static void main(String[] args) {
        PerfectNumber perfectNumber = new PerfectNumber();

        perfectNumber.checkPerfectNumber(28);
    }
    public boolean checkPerfectNumber(int num) {
        int devisorsSum = ((int) Math.pow(2,num-1)) * ((int)  (Math.pow(2,num) -1));
        System.out.print(devisorsSum);
        return num == devisorsSum;
    }
}
